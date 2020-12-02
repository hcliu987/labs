package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

public class Demo02Message implements Serializable {

  public static final String QUEUE = "QUEUE_DEMO_02";
  public static final String EXCHANGE = "EXCHANGE_DEMO_02";
  public static final String ROUTING_KEY = "#.yu.nai";
  private static final long serialVersionUID = -709255724620538558L;
  /**
   * 编号
   */
  private Integer id;

  @Override
  public String toString() {
    return "Demo02Message{" +
        "id=" + id +
        '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
