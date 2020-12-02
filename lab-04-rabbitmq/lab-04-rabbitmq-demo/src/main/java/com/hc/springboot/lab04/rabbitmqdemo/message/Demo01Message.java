package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

public class Demo01Message implements Serializable {

  public static final String QUEUE = "QUEUE_DEMO_01";
  public static final String EXCHANGE = "EXCHANGE_DEMO_01";
  public static final String ROUTING_KEY = "ROTING_KEY_01";
  private static final long serialVersionUID = 3979808834226509519L;
  /**
   * 编号
   */
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Demo01Message{" +
        "id=" + id +
        '}';
  }
}
