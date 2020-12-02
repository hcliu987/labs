package com.hc.springboot.lab04.rabbitmqdemo.message;


import java.io.Serializable;

public class Demo04Message implements Serializable {

  public static final String QUEUE = "QUEUE_DEMO_04_A";

  public static final String EXCHANGE = "EXCHANGE_DEMO_04";

  public static final String HEADER_KEY = "color";
  public static final String HEADER_VALUE = "red";
  private static final long serialVersionUID = 1429158920017337738L;

  /**
   * 编号
   */
  private Integer id;

  @Override
  public String toString() {
    return "Demo04Message{" +
        "id=" + id +
        '}';
  }

  public Integer getId() {
    return id;
  }

  public Demo04Message setId(Integer id) {
    this.id = id;
    return this;
  }
}
