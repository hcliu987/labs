package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

public class Demo09Message  implements Serializable {
    private static final long serialVersionUID = 5579333789766217016L;
    public static final String QUEUE = "QUEUE_DEMO_09";

    public static final String EXCHANGE = "EXCHANGE_DEMO_09";

    public static final String ROUTING_KEY = "ROUTING_KEY_09";

    /**
     * 编号
     */
    private Integer id;

    public Demo09Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Demo09Message{" +
                "id=" + id +
                '}';
    }

}
