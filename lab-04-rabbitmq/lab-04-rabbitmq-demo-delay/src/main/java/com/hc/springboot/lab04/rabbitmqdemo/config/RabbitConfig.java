package com.hc.springboot.lab04.rabbitmqdemo.config;

import com.hc.springboot.lab04.rabbitmqdemo.message.Demo08Message;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static class DirectExchangeDemoConfiguration {
        @Bean
        public Queue demo08Queue() {
            return QueueBuilder.durable(Demo08Message.QUEUE)
                    .exclusive()
                    .autoDelete()
                    .ttl(10 * 1000)
                    .deadLetterRoutingKey(Demo08Message.DELAY_ROUTING_KEY)
                    .deadLetterExchange(Demo08Message.EXCHANGE)
                    .build();
        }

        @Bean
        public Queue demo08DelayQueue() {
            return new Queue(Demo08Message.DELAY_QUEUE,
                    true,
                    false, false);
        }

        @Bean
        public DirectExchange demo08Exchange() {
            return new DirectExchange(Demo08Message.EXCHANGE, true, false);
        }

        @Bean
        public Binding demo08Binding() {
            return BindingBuilder.bind(demo08Queue()).to(demo08Exchange()).with(Demo08Message.ROUTING_KEY);
        }

        @Bean
        public Binding demo08DelayBinding() {
            return BindingBuilder.bind(demo08DelayQueue()).to(demo08Exchange()).with(Demo08Message.DELAY_ROUTING_KEY);
        }
    }
}
