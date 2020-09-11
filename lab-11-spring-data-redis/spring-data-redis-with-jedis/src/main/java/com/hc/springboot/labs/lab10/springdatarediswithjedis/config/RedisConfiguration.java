package com.hc.springboot.labs.lab10.springdatarediswithjedis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfiguration {


    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        //创建redistemplate 对象
        RedisTemplate<String,Object> template =new RedisTemplate<>();

        //设置开启事务支持
        template.setConnectionFactory(factory);
        //使用string 序列化方式，序列化key
        template.setKeySerializer(RedisSerializer.string());
        //使用json 序列化方式
        template.setValueSerializer(RedisSerializer.json());
        return template;
    }
}
