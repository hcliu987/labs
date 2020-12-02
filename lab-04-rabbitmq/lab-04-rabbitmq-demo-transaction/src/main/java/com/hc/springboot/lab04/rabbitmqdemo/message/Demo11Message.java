package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

public class Demo11Message implements Serializable {

  public static final String QUEUE = "QUEUE_DEMO_11";
  public static final String EXCHANGE = "EXCHANGE_DEMO_11";
  public static final String ROUTING_KEY = "ROUTING_KEY_11";
  private static final long serialVersionUID = 484705677223838569L;
  /**
   * 编号
   */
  private Integer id;

  public Integer getId() {
    return id;
  }

  public Demo11Message setId(Integer id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "Demo11Message{" +
        "id=" + id +
        '}';
  }
}
