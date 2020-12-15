package com.hc.lab12.mybatis.service;

import com.alibaba.fastjson.JSON;
import com.hc.lab12.mybatis.dataobject.UserDO;
import com.hc.lab12.mybatis.filter.RedisBloomFilter;
import com.hc.lab12.mybatis.mapper.UserMapper;
import com.hc.lab12.mybatis.template.CacheLoadble;
import com.hc.lab12.mybatis.template.CacheTemplate;
import com.hc.lab12.mybatis.util.RedisLock;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private RedisTemplate redisTemplate;
  @Autowired
  CacheTemplate cacheTemplate;
  @Autowired
  UserMapper userMapper;
  @Autowired
  RedisBloomFilter bloomFilter;

  @Autowired
  private RedisLock redisLock;

  public String selectUserById(Integer id) throws Exception {
    // 缓存查询
    Object redisObj = redisTemplate.opsForValue().get(String.valueOf(id));
    // 命中缓存
    if (redisObj != null) {
      return JSON.toJSONString(redisObj);
    }
    try {
      redisLock.lock(String.valueOf(id));

      // 查询缓存
      redisObj = redisTemplate.opsForValue().get(String.valueOf(id));
      if (redisObj != null) {
        return JSON.toJSONString(redisObj);
      }
      UserDO user = userMapper.selectById(id);
      if (user != null) {
        redisTemplate.opsForValue().set(String.valueOf(id), user);
        return user.toString();
      }

    } finally {
      redisLock.unLock(String.valueOf(id));
    }
    return "查询无果";
  }

  public String selectByid(Integer id) {
    if (!bloomFilter.isExist(id.toString())) {
      return "查询无果";
    }
    Object redisObj = redisTemplate.opsForValue().get(id.toString());
    if (redisObj != null) {
      return JSON.toJSONString(redisObj);
    }
    UserDO user = userMapper.selectById(id);
    if (user != null) {
      redisTemplate.opsForValue().set(id, user);
      return JSON.toJSONString(user);
    }
    return "查询无果";
  }

  public String synchronizedSelectUserById(Integer id) {
    return cacheTemplate.findCache(String.valueOf(id), 10, TimeUnit.MINUTES, new CacheLoadble() {
      @Override
      public Object load() {
        return userMapper.selectById(id);
      }
    });
  }
}

