package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

public class Demo07Message implements Serializable {

  public static final String QUEUE = "QUEUE_DEMO_07"; // 正常队列
  public static final String DEAD_QUEUE = "DEAD_QUEUE_DEMO_07"; // 死信队列
  public static final String EXCHANGE = "EXCHANGE_DEMO_07";
  public static final String ROUTING_KEY = "ROUTING_KEY_07"; // 正常路由键
  public static final String DEAD_ROUTING_KEY = "DEAD_ROUTING_KEY_07"; // 死信路由键
  private static final long serialVersionUID = 1341924798852533052L;
  /**
   * 编号
   */
  private Integer id;

  public Integer getId() {
    return id;
  }

  public Demo07Message setId(Integer id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "Demo07Message{" +
        "id=" + id +
        '}';
  }
}
