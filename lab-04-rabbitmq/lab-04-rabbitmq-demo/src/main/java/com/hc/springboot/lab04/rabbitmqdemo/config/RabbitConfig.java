package com.hc.springboot.lab04.rabbitmqdemo.config;

import com.hc.springboot.lab04.rabbitmqdemo.message.Demo01Message;
import com.hc.springboot.lab04.rabbitmqdemo.message.Demo02Message;
import com.hc.springboot.lab04.rabbitmqdemo.message.Demo03Message;
import com.hc.springboot.lab04.rabbitmqdemo.message.Demo04Message;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /**
     * Direct Exchange 示例的配置类
     */
    public static class DirectExchangeDemoConfiguration {
        /**
         * 创建queue
         *
         * @return
         */
        @Bean
        public Queue demo01Queue() {
            return new Queue(Demo01Message.QUEUE,// queue 名字
                    true,//durable:是否持久化
                    false,//exclusive:是否排他
                    false);//自动删除
        }

        /**
         * 创建 direct exchange
         *
         * @return
         */
        @Bean
        public DirectExchange demo01Exchange() {
            return new DirectExchange(Demo01Message.EXCHANGE,
                    true,//durable：是否持久化
                    false);//exclusiuve:是否排他
        }

        /**
         * 创建binding
         * Exchange：Demo01Message.EXCHANGE
         * Routing key：Demo01Message.ROUTING_KEY
         * Queue：Demo01Message.QUEUE
         */
        @Bean
        public Binding demo01Binding() {
            return BindingBuilder.bind(demo01Queue()).to(demo01Exchange()).with(Demo01Message.ROUTING_KEY);
        }
    }

    /**
     * Topic Exchange 示例的配置类
     */
    public static class TopicExchangeDemoConfiguration {
        //创建queue
        @Bean
        public Queue demo02Queue() {
            return new Queue(Demo02Message.QUEUE,//queue 名字
                    true,//durable 是否持久化
                    false,//是否排他
                    false);//是否自动删除
        }

        //创建topic exchange
        @Bean
        public TopicExchange demo02Exchange() {
            return new TopicExchange(Demo02Message.EXCHANGE,
                    true, false);
        }

        @Bean
        public Binding demo02Binding() {
            return BindingBuilder.bind(demo02Queue()).to(demo02Exchange()).with(Demo02Message.ROUTING_KEY);
        }
    }

    /**
     * Fanout Exchange 示例的配置类
     */
    public static  class  FanoutExchangeDemoConfiguration{
        //创建queue A
        @Bean
        public  Queue demo03QueueA(){
            return  new Queue(Demo03Message.QUEUE_A, //queue 名字
                    true,//durable:是否持久化
                    false,//exclusive:是否排他
                    false);//是否自动删除
        }
        //创建queue B
        @Bean
        public  Queue demo03QueueB(){
            return  new Queue(Demo03Message.QUEUE_B, //queue 名字
                    true,//durable:是否持久化
                    false,//exclusive:是否排他
                    false);//是否自动删除
        }
        //创建 Fanout Exchange
        @Bean
        public  FanoutExchange demo03Exchange(){
            return  new FanoutExchange(Demo03Message.EXCHANGE,
                    true,//是否持久化
                    false); //是否排他
        }

        /**
         * 创建binding a
         *  exchange: demo03message.exchange
         *  queue : demo03messgae.queue
         */
        @Bean
        public  Binding demo03BindingA(){
            return  BindingBuilder.bind(demo03QueueA()).to(demo03Exchange());
        }
        /**
         * 创建binding b
         *  exchange: demo03message.exchange
         *  queue : demo03messgae.queue
         */
        @Bean
        public  Binding demo03Bindingb(){
            return  BindingBuilder.bind(demo03QueueB()).to(demo03Exchange());
        }
    }

    /**
     * headers exchange 示例的配置类
     */
    public  static  class  HeadersExchangeDemoConfiguration{
        //创建queue
        @Bean
        public  Queue demo04Queue(){
            return  new Queue(Demo04Message.QUEUE,
                    true,false,false);
        }
        //创建headers exchange
        @Bean
        public  HeadersExchange demo04Exchange(){
            return  new HeadersExchange(Demo04Message.EXCHANGE,true,false);
        }
        //创建binding
        @Bean
        public  Binding demo04Binding(){
            return  BindingBuilder.bind(demo04Queue()).to(demo04Exchange()).where(Demo04Message.HEADER_KEY)
                    .matches(Demo04Message.HEADER_VALUE);
        }
    }



}
