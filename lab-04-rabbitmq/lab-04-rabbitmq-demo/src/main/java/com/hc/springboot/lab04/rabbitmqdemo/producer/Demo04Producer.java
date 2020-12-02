package com.hc.springboot.lab04.rabbitmqdemo.producer;

import com.hc.springboot.lab04.rabbitmqdemo.message.Demo04Message;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Demo04Producer {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  public void syncSend(Integer id, String headerValue) {
    //创建messageProperties属性
    MessageProperties messageProperties = new MessageProperties();
    messageProperties.setHeader(Demo04Message.HEADER_KEY, headerValue);
    //创建message消息
    Message message = rabbitTemplate.getMessageConverter().toMessage(
        new Demo04Message().setId(id), messageProperties);
    //发送同步消息
    rabbitTemplate.convertAndSend(Demo04Message.EXCHANGE, null, message);
  }
}
