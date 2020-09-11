package com.hc.springboot.lab04.rabbitmqdemo.config;

import com.hc.springboot.lab04.rabbitmqdemo.message.BroadcastMessage;
import com.hc.springboot.lab04.rabbitmqdemo.message.ClusteringMessage;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    // 创建Topic Exchange
    @Bean
    public TopicExchange broadcastingExchange() {
        return new TopicExchange(BroadcastMessage.EXCHANGE,
                true, false);
    }

    /**
     * 集群消费的示例的配置
     */
    public static class ClusteringConfiguration {
        //创建 topic exchange
        @Bean
        public TopicExchange clusteringExchange() {
            return  new TopicExchange(ClusteringMessage.EXCHANGE,
            true,false);
        }

    }

}
