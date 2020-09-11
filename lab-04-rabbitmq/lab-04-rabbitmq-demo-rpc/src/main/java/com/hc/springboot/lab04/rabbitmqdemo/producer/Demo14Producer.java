package com.hc.springboot.lab04.rabbitmqdemo.producer;

import com.hc.springboot.lab04.rabbitmqdemo.message.Demo14Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Demo14Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String syncSend(Integer id) {
        Demo14Message message=new Demo14Message();
        message.setId(id);
        // <1> 创建 CorrelationData 对象
        CorrelationData correlationData =new CorrelationData(UUID.randomUUID().toString());
        // <2> 同步发送消息，并接收结果
        return (String) rabbitTemplate.convertSendAndReceive(Demo14Message.EXCHANGE,Demo14Message.ROUTING_KEY,message,correlationData);
    }
}
