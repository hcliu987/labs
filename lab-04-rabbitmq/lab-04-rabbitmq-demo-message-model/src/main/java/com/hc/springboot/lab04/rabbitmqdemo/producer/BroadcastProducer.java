package com.hc.springboot.lab04.rabbitmqdemo.producer;

import com.hc.springboot.lab04.rabbitmqdemo.message.BroadcastMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BroadcastProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        //创建BroadcastMessage 消息
        BroadcastMessage message = new BroadcastMessage();
        message.setId(id);
        //发送消息
        rabbitTemplate.convertAndSend(BroadcastMessage.EXCHANGE,null,message);
    }

}
