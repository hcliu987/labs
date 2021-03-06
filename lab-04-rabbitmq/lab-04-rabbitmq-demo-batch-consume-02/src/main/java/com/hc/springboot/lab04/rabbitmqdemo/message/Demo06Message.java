package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

public class Demo06Message implements Serializable {

  public static final String QUEUE = "QUEUE_DEMO_06";

  public static final String EXCHANGE = "EXCHANGE_DEMO_06";

  public static final String ROUTING_KEY = "ROUTING_KEY_06";
  private static final long serialVersionUID = 7767249721923031235L;

  /**
   * 编号
   */
  private Integer id;

  public Integer getId() {
    return id;
  }

  public Demo06Message setId(Integer id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "Demo06Message{" +
        "id=" + id +
        '}';
  }
}
