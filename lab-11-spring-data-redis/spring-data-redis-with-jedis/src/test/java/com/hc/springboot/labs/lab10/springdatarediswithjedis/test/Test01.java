package com.hc.springboot.labs.lab10.springdatarediswithjedis.test;

import com.hc.springboot.labs.lab10.springdatarediswithjedis.Application;
import com.hc.springboot.labs.lab10.springdatarediswithjedis.cacheobject.UserCacheObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test01 {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void testStringSetKey() {
        stringRedisTemplate.opsForValue().set("yunai", "shuai");
    }

    @Test
    public void testStringSetKey02() {
        redisTemplate.opsForValue().set("yunai", "shuai");
    }

    @Test
    public void testSetAdd() {
        stringRedisTemplate.opsForSet().add("yunai_descriptions", "shuai", "cai");
    }


    @Test
    public void testStringSetKeyUserCache() {
        UserCacheObject user = new UserCacheObject()
                .setId(1)
                .setName("hc")
                .setGender(1);
        String key = String.format("user:%d", user.getId());
        redisTemplate.opsForValue().set(key, user);
    }

    @Test
    public void testStringGetKeyUserCache() {
        String key = String.format("user:%d", 1);
        Object value = redisTemplate.opsForValue().get(key);
        System.out.println(value);
    }
}
