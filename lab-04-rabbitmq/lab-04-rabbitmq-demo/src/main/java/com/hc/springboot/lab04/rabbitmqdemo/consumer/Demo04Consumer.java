package com.hc.springboot.lab04.rabbitmqdemo.consumer;

import com.hc.springboot.lab04.rabbitmqdemo.message.Demo04Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = Demo04Message.QUEUE)
public class Demo04Consumer {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @RabbitHandler
  public void onMessage(Demo04Message message) {
    logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
  }
//    @RabbitHandler(isDefault = true)
//    public void onMessage(org.springframework.amqp.core.Message message) {
//        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
//    }
}
