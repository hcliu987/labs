package com.hc.lab12.mybatis.util;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisService {

  @Autowired
  private RedisTemplate redisTemplate;

  /**
   * 默认过期时长,单位秒
   */
  public static final long DEFAULT_EXPIRE = 60 * 60 * 24;

  /**
   * 不设置过期时间
   */
  public static final long NOT_EXPIRE = -1;

  public boolean existsKey(String key) {
    return redisTemplate.hasKey(key);
  }

  public void renameKey(String oldKey, String newKey) {
    redisTemplate.rename(oldKey, newKey);
  }

  /**
   * newKey不存在时才重命名
   */
  public boolean renameKeyNotExist(String oldKey, String newKey) {
    return redisTemplate.renameIfAbsent(oldKey, newKey);
  }

  public void deleteKey(String key) {
    redisTemplate.delete(key);
  }

  /**
   * 删除多个key
   */
  public void deleteKey(String... key) {
    Set<String> collect = Stream.of(key).map(k -> k).collect(Collectors.toSet());
    redisTemplate.delete(collect);
  }

  /**
   * 设置key的生命周期
   */
  public void expireKey(String key, long time, TimeUnit timeUnit) {
    redisTemplate.expire(key, time, timeUnit);
  }

  /**
   * key在指定的日期过期
   */

  public void expireKeyAt(String key, Date date) {
    redisTemplate.expireAt(key, date);
  }

  /**
   * 查询key的生命周期
   *
   * @param key
   * @param timeUnit
   * @return
   */
  public long getKeyExpire(String key, TimeUnit timeUnit) {
    return redisTemplate.getExpire(key, timeUnit);
  }

  /**
   * 将key设置为永久有效
   *
   * @param key
   */
  public void persistKey(String key) {
    redisTemplate.persist(key);
  }
}
