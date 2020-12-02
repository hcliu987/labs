package com.hc.springboot.lab16.springdatamongodb.mongo;

import org.springframework.data.annotation.Id;

public abstract class IncIdEntity<T extends Number> {

  @Id
  private T id;

  public T getId() {
    return id;
  }

  public void setId(T id) {
    this.id = id;
  }
}
