package com.hc.springboot.labs.lab10.springdatarediswithjedis.test;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScriptTest {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Test
  public void test01() throws IOException {
    String scriptContents = IOUtils
        .toString(getClass().getResourceAsStream("/lua/compareAndSet.lua"));
    //创建redisscript对象
    RedisScript<Long> script = new DefaultRedisScript<>(scriptContents, Long.class);
    //执行lua脚本
    Long result = stringRedisTemplate
        .execute(script, Collections.singletonList("yunai:1"), "shuai02", "shuai");
    System.out.println(result);
  }

  @Test
  public void test02() throws IOException {
    String scriptContents = IOUtils
        .toString(getClass().getResourceAsStream("/lua/test.lua"), "UTF-8");
    // 创建 RedisScript 对象
    RedisScript<List> script = new DefaultRedisScript<>(scriptContents, List.class);

    List<Object> result = stringRedisTemplate
        .execute(script, Arrays.asList("key1", "key2"), "first", "second");
    System.out.println(result);
  }
}
