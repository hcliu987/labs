package com.hc.springboot.lab04.rabbitmqdemo.producer;

import com.hc.springboot.lab04.rabbitmqdemo.message.Demo05Message;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Demo06Producer {
    @Autowired
    private BatchingRabbitTemplate batchingRabbitTemplate;

    public void syncSend(Integer id) {
        //创建demo5message对象
        Demo05Message message = new Demo05Message();
        message.setId(id);
        //同步发送消息
        batchingRabbitTemplate.convertAndSend(Demo05Message.EXCHANGE,Demo05Message.ROUTING_KEY,message);
    }
}
