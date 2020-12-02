package com.hc.springboot.lab04.rabbitmqdemo.producer;

import com.hc.springboot.lab04.rabbitmqdemo.message.Demo05Message;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Demo05Producer {

  @Autowired
  private BatchingRabbitTemplate batchingRabbitTemplate;

  public void syncSend(Integer id) {
    //创建Demo05Message 消息
    Demo05Message message = new Demo05Message();
    message.setId(id);
    //发送同步消息
    batchingRabbitTemplate
        .convertAndSend(Demo05Message.EXCHANGE, Demo05Message.ROUTING_KEY, message);
  }


}
