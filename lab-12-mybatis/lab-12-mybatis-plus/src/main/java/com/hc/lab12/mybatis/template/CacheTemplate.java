package com.hc.lab12.mybatis.template;

import com.alibaba.fastjson.JSON;
import com.hc.lab12.mybatis.filter.RedisBloomFilter;
import com.hc.lab12.mybatis.mapper.UserMapper;
import com.hc.lab12.mybatis.util.RedisLock;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CacheTemplate<T> {

  @Autowired
  private RedisTemplate redisTemplate;

  @Autowired
  private RedisBloomFilter bloomFilter;

  @Autowired
  private RedisLock redisLock;

  @Autowired
  UserMapper userMapper;

  public String findCache(String key, long expire, TimeUnit unit, CacheLoadble<T> cacheLoadble) {
    // 查询缓存
    Object redisObj = redisTemplate.opsForValue().get(String.valueOf(key));
    if (redisObj != null) {
      return JSON.toJSONString(redisObj);
    }
    synchronized (this) {
      redisObj = redisTemplate.opsForValue().get(String.valueOf(key));
      if (redisObj != null) {
        return JSON.toJSONString(redisObj);
      }
      T load = cacheLoadble.load();

      redisTemplate.opsForValue().set(String.valueOf(key), load, expire, unit);
      return JSON.toJSONString(redisObj);
    }
  }

  public String redisFindCache(
      String key, long expire, TimeUnit unit, CacheLoadble<T> cacheLoadble, boolean b)
      throws Exception {
    if (b) {
      boolean exist = bloomFilter.isExist(key);
      if (!exist) {
        return "查询无果";
      }
    }
    Object redisObj = redisTemplate.opsForValue().get(key);
    if (redisObj != null) {
      return JSON.toJSONString(redisObj);
    }
    try {
      redisLock.lock(key);
      redisObj = redisTemplate.opsForValue().get(String.valueOf(key));
      if (redisObj != null) {
        return JSON.toJSONString(redisObj);
      }
      T load = cacheLoadble.load();
      if (load != null) {
        redisTemplate.opsForValue().set(key, load, expire, unit);
        return JSON.toJSONString(load);
      }
      return "查询无果";

    } finally {
      redisLock.unLock(key);
    }
  }
}
