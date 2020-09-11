package com.hc.springboot.lab04.rabbitmqdemo.producer;

import com.hc.springboot.lab04.rabbitmqdemo.message.Demo07Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Demo07Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id) {
        //创建demo07producer
        Demo07Message message=new Demo07Message();
        message.setId(id);
        //同步发送消息
        rabbitTemplate.convertAndSend(Demo07Message.EXCHANGE,Demo07Message.ROUTING_KEY,message);
    }

}
