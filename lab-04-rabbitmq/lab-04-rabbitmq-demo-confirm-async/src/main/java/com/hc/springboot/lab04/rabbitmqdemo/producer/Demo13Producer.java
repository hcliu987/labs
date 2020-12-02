package com.hc.springboot.lab04.rabbitmqdemo.producer;

import com.hc.springboot.lab04.rabbitmqdemo.message.Demo13Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Demo13Producer {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  public void syncSend(Integer id) {
    Demo13Message message = new Demo13Message();
    message.setId(id);
    rabbitTemplate.convertAndSend(Demo13Message.EXCHANGE, Demo13Message.ROUTING_KEY, message);
  }

  public void syncSendReturn(Integer id) {
    Demo13Message message = new Demo13Message();
    message.setId(id);
    rabbitTemplate.convertAndSend(Demo13Message.EXCHANGE, "error", message);
  }
}
