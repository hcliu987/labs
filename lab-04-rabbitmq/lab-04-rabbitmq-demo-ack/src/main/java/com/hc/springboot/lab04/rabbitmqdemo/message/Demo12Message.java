package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

public class Demo12Message implements Serializable {
    private static final long serialVersionUID = 3336363674806253832L;

    public static final String QUEUE = "QUEUE_DEMO_12";

    public static final String EXCHANGE = "EXCHANGE_DEMO_12";

    public static final String ROUTING_KEY = "ROUTING_KEY_12";

    /**
     * 编号
     */
    private Integer id;

    public Demo12Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Demo12Message{" +
                "id=" + id +
                '}';
    }
}
