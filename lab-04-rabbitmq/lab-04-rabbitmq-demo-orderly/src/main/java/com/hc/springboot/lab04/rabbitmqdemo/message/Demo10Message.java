package com.hc.springboot.lab04.rabbitmqdemo.message;

import java.io.Serializable;

public class Demo10Message implements Serializable {

  public static final int QUEUE_COUNT = 4;
  public static final String EXCHANGE = "EXCHANGE_DEMO_10";
  private static final long serialVersionUID = -5684139656523082322L;
  private static final String QUEUE_BASE = "QUEUE_DEMO_10-";
  public static final String QUEUE_0 = QUEUE_BASE + "0";
  public static final String QUEUE_1 = QUEUE_BASE + "1";
  public static final String QUEUE_2 = QUEUE_BASE + "2";
  public static final String QUEUE_3 = QUEUE_BASE + "3";
  /**
   * 编号
   */
  private Integer id;

  public Integer getId() {
    return id;
  }

  public Demo10Message setId(Integer id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "Demo10Message{" +
        "id=" + id +
        '}';
  }
}
