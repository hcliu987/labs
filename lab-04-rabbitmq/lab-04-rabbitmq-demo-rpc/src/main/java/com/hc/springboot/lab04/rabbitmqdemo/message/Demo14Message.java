package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

public class Demo14Message implements Serializable {

  public static final String QUEUE = "QUEUE_DEMO_14";
  public static final String EXCHANGE = "EXCHANGE_DEMO_14";
  public static final String ROUTING_KEY = "ROUTING_KEY_14";
  private static final long serialVersionUID = -5517245362271416975L;
  /**
   * 编号
   */
  private Integer id;

  public Integer getId() {
    return id;
  }

  public Demo14Message setId(Integer id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "Demo14Message{" +
        "id=" + id +
        '}';
  }

}
