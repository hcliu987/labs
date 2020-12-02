package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

public class Demo16Message implements Serializable {

  public static final String QUEUE = "QUEUE_DEMO_16";
  public static final String EXCHANGE = "EXCHANGE_DEMO_16";
  public static final String ROUTING_KEY = "ROUTING_KEY_16";
  private static final long serialVersionUID = 32501941496685137L;
  /**
   * 编号
   */
  private Integer id;

  public Integer getId() {
    return id;
  }

  public Demo16Message setId(Integer id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "Demo16Message{" +
        "id=" + id +
        '}';
  }
}
