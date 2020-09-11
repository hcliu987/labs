package com.hc.springboot.lab04.rabbitmqdemo.config;

import com.hc.springboot.lab04.rabbitmqdemo.message.Demo05Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.batch.BatchingStrategy;
import org.springframework.amqp.rabbit.batch.SimpleBatchingStrategy;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Configuration
public class RabbitConfig {
    public static class DirectExchangeConfiguration {

        //创建queue
        @Bean
        public Queue demo05Queue() {
            return new Queue(Demo05Message.QUEUE, true, false, false);
        }

        //创建 direct exchange
        @Bean
        public DirectExchange demo05Exchange() {
            return new DirectExchange(Demo05Message.EXCHANGE, true, false);
        }

        //创建binding
        @Bean
        public Binding demo05Bing() {
            return BindingBuilder.bind(demo05Queue()).to(demo05Exchange()).with(Demo05Message.ROUTING_KEY);
        }

        @Bean
        public BatchingRabbitTemplate batchingRabbitTemplate(ConnectionFactory factory) {
            //创建 BatchingStrategy对象.代表批量策略
            int batchSize = 16384;//超过收集的消息数量的最大条数
            int bufferLimit = 33554432;//每次批量发送消息的最大内存
            int timeout = 30000;//超过收集的时间的最大等待时长
            BatchingStrategy batchingStrategy = new SimpleBatchingStrategy(batchSize, bufferLimit, timeout);
            //创建taskscheduler 对象，用于实现超时发送的定时器
            TaskScheduler taskScheduler = new ConcurrentTaskScheduler();
            //创建batchingRabbitTemplate对象
            BatchingRabbitTemplate rabbitTemplate = new BatchingRabbitTemplate(batchingStrategy, taskScheduler);
            rabbitTemplate.setConnectionFactory(factory);
            return rabbitTemplate;
        }
    }
}
