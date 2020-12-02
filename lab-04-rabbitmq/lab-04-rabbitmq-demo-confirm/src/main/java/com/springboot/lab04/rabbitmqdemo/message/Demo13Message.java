package com.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

public class Demo13Message implements Serializable {

  public static final String QUEUE = "QUEUE_DEMO_13";
  public static final String EXCHANGE = "EXCHANGE_DEMO_13";
  public static final String ROUTING_KEY = "ROUTING_KEY_13";
  private static final long serialVersionUID = 6343435691294482321L;
  /**
   * 编号
   */
  private Integer id;

  public Integer getId() {
    return id;
  }

  public Demo13Message setId(Integer id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "Demo13Message{" +
        "id=" + id +
        '}';
  }

}
