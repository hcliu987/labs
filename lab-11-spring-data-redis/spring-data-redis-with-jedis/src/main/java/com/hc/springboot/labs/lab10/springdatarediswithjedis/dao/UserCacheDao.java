package com.hc.springboot.labs.lab10.springdatarediswithjedis.dao;

import com.alibaba.fastjson.JSON;
import com.hc.springboot.labs.lab10.springdatarediswithjedis.cacheobject.UserCacheObject;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserCacheDao {

  private static final String KEY_PATTERN = "user:%d";

  @Resource(name = "redisTemplate")
  private ValueOperations<String, String> operations;


  public static String buildKey(Integer id) {
    return String.format(KEY_PATTERN, id);
  }

  public UserCacheObject get(Integer id) {
    String key = buildKey(id);
    String value = operations.get(key);
    return JSON.parseObject(value, UserCacheObject.class);
  }

  public void set(Integer id, UserCacheObject object) {
    String key = buildKey(id);
    String value = JSON.toJSONString(object);
    operations.set(key, value);
  }
}
