package com.hc.lab12.mybatis.util;

public interface Lock {

  void lock(String key);

  boolean tryLock(String key);

  void unLock(String key) throws Exception;
}
