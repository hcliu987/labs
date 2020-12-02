package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

/**
 * 广播消费的消息示例
 */
public class BroadcastMessage implements Serializable {

  public static final String QUEUE = "QUEUE_BROADCASTING";
  public static final String EXCHANGE = "EXCHANGE_BROADCASTING";
  private static final long serialVersionUID = -1660835822950405926L;
  /**
   * 编号
   */
  private Integer id;

  public Integer getId() {
    return id;
  }

  public BroadcastMessage setId(Integer id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "BroadcastMessage{" +
        "id=" + id +
        '}';
  }
}
