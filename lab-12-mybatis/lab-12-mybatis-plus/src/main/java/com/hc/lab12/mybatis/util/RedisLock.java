package com.hc.lab12.mybatis.util;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import redis.clients.jedis.commands.JedisCommands;

@Component
public class RedisLock implements Lock {

  @Autowired
  RedisTemplate redisTemplate;

  public static final String KEYPREFIX = "lock";
  public static final String UNLOCK_LUA;

  static {
    StringBuffer buffer = new StringBuffer();
    buffer.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
    buffer.append("then ");
    buffer.append("    return redis.call(\"del\",KEYS[1]) ");
    buffer.append("else ");
    buffer.append("    return 0 ");
    buffer.append("end ");
    UNLOCK_LUA = buffer.toString();
  }

  // threadlocak 用于保存某个线程共享变量,对于同一个static threadLocal,不同线程只能get,set,remove自己的变量
  private ThreadLocal<String> threadLocal = new ThreadLocal<>();

  @Override
  public void lock(String key) {
    boolean b = tryLock(key);
    if (b) {
      return;
    }
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    lock(key);
  }

  @Override
  public boolean tryLock(String key) {
    String uuid = UUID.randomUUID().toString();
    RedisCallback<String> callback =
        (connection) -> {
          JedisCommands commands = (JedisCommands) connection.getNativeConnection();
          return commands.set(KEYPREFIX + key, uuid);
        };
    Object execute = redisTemplate.execute(callback);
    if (execute != null) {
      threadLocal.set(uuid);
      return true;
    }
    return false;
  }

  @Override
  public void unLock(String key) throws Exception {
    RedisCallback redisScript =
        new RedisCallback() {
          @Nullable
          @Override
          public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
            Object eval =
                redisConnection.eval(
                    UNLOCK_LUA.getBytes(),
                    ReturnType.fromJavaType(Long.class),
                    1,
                    (KEYPREFIX + key).getBytes());
            return eval;
          }
        };
    redisTemplate.execute(redisScript);
  }
}
