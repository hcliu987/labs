package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

/**
 * 广播消费的消息示例
 */
public class BroadcastMessage  implements Serializable {

    private static final long serialVersionUID = -1660835822950405926L;
    public static final String QUEUE = "QUEUE_BROADCASTING";

    public static final String EXCHANGE = "EXCHANGE_BROADCASTING";

    /**
     * 编号
     */
    private Integer id;

    public BroadcastMessage setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BroadcastMessage{" +
                "id=" + id +
                '}';
    }
}
