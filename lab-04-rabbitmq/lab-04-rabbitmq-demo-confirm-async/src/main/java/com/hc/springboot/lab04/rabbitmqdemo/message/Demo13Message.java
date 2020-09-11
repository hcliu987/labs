package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

public class Demo13Message  implements Serializable {
    private static final long serialVersionUID = -2058619162394602538L;
    public static final String QUEUE = "QUEUE_DEMO_13";

    public static final String EXCHANGE = "EXCHANGE_DEMO_13";

    public static final String ROUTING_KEY = "ROUTING_KEY_13";

    /**
     * 编号
     */
    private Integer id;

    public Demo13Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Demo13Message{" +
                "id=" + id +
                '}';
    }

}
