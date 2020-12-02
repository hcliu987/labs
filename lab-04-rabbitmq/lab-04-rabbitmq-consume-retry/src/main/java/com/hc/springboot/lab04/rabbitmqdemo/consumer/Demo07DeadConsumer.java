package com.hc.springboot.lab04.rabbitmqdemo.consumer;

import com.hc.springboot.lab04.rabbitmqdemo.message.Demo07Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = Demo07Message.DEAD_QUEUE)
public class Demo07DeadConsumer {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @RabbitListener
  public void onMessage(Demo07Message message) {
    logger.info("[onMessage][[死信队列]线程编号:{}消息内容{}]", Thread.currentThread().getId(), message);
  }
}
