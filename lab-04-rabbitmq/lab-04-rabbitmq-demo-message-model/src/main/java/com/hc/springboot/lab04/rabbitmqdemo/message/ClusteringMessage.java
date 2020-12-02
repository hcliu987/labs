package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

/**
 * 广播消费的消息示例
 */
public class ClusteringMessage implements Serializable {

  public static final String QUEUE = "QUEUE_CLUSTERING";
  public static final String EXCHANGE = "EXCHANGE_CLUSTERING";
  private static final long serialVersionUID = -4500872460184041398L;
  /**
   * 编号
   */
  private Integer id;

  public Integer getId() {
    return id;
  }

  public ClusteringMessage setId(Integer id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "ClusteringtMessage{" +
        "id=" + id +
        '}';
  }
}
