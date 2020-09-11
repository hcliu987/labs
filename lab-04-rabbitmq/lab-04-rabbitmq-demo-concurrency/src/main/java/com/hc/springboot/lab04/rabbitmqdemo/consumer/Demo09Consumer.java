package com.hc.springboot.lab04.rabbitmqdemo.consumer;

import com.hc.springboot.lab04.rabbitmqdemo.message.Demo09Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component

@RabbitListener(queues = Demo09Message.QUEUE, concurrency = "2")
public class Demo09Consumer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onMessage(Demo09Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
