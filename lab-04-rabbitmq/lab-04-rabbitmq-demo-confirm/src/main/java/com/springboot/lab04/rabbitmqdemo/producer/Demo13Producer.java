package com.springboot.lab04.rabbitmqdemo.producer;

import com.rabbitmq.client.ConfirmCallback;
import com.springboot.lab04.rabbitmqdemo.message.Demo13Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Demo13Producer {

  private Logger logger = LoggerFactory.getLogger(getClass());
  @Autowired
  private RabbitTemplate rabbitTemplate;

  public void syncSend(Integer id) {
    Demo13Message message = new Demo13Message();
    message.setId(id);
    //同步发送消息
    rabbitTemplate.invoke(new RabbitOperations.OperationsCallback<Object>() {
      @Override
      public Object doInRabbit(RabbitOperations rabbitOperations) {
        //同步发送消息
        rabbitOperations.convertAndSend(Demo13Message.EXCHANGE, Demo13Message.ROUTING_KEY, message);
        logger.info("[doInRabbit][发送消息完成]");
        rabbitOperations.waitForConfirms(0);//timeout 参数。0表示为无限等待
        logger.info("[doInRabbit][等待 Confirm 完成]");
        return null;
      }
    }, new ConfirmCallback() {
      @Override
      public void handle(long l, boolean b) throws IOException {
        logger.info("[handle][Confirm成功】");

      }
    }, new ConfirmCallback() {
      @Override
      public void handle(long l, boolean b) throws IOException {
        logger.info("[handle][Confirm失败】");
      }
    });
  }
}
