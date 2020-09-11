package com.hc.springboot.labs.lab10.springdatarediswithjedis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PipelineTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {
        List<Object> objects = stringRedisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                //set 写入
                for (int i = 0; i < 3; i++) {
                    redisConnection.set(String.format("user:%d", i).getBytes(), "shuai".getBytes());
                }

                //get
                for (int i = 0; i < 3; i++) {
                    redisConnection.get(String.format("user:%d", i).getBytes());
                }
                return null;

            }
        });
        System.out.println(objects);
    }
}
