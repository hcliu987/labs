package com.hc.springboot.lab04.rabbitmqdemo.config;

import com.hc.springboot.lab04.rabbitmqdemo.message.Demo07Message;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

  @Bean
  public Queue demo07Queue() {
    return QueueBuilder.durable(Demo07Message.QUEUE)
        .exclusive()
        .autoDelete()
        .deadLetterExchange(Demo07Message.EXCHANGE)
        .deadLetterRoutingKey(Demo07Message.ROUTING_KEY)
        .build();
  }

  @Bean
  public Queue demo07DeadQueue() {
    return new Queue(Demo07Message.QUEUE, true, false, false);
  }

  @Bean
  public DirectExchange demo07Exchange() {
    return new DirectExchange(Demo07Message.EXCHANGE, true, false);
  }

  @Bean
  public Binding demo07Binding() {
    return BindingBuilder.bind(demo07Queue()).to(demo07Exchange()).with(Demo07Message.ROUTING_KEY);
  }

  @Bean
  public Binding demo07DeadBinding() {
    return BindingBuilder.bind(demo07DeadQueue()).to(demo07Exchange())
        .with(Demo07Message.DEAD_ROUTING_KEY);
  }
}
