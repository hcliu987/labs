package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

/**
 * 广播消费的消息示例
 */
public class ClusteringMessage  implements Serializable {
    private static final long serialVersionUID = -4500872460184041398L;
    public static final String QUEUE = "QUEUE_CLUSTERING";

    public static final String EXCHANGE = "EXCHANGE_CLUSTERING";

    /**
     * 编号
     */
    private Integer id;

    public ClusteringMessage setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ClusteringtMessage{" +
                "id=" + id +
                '}';
    }
}
