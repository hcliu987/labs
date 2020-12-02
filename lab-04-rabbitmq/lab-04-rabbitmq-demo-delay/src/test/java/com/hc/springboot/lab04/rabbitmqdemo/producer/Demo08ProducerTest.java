package com.hc.springboot.lab04.rabbitmqdemo.producer;

import com.hc.springboot.lab04.rabbitmqdemo.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Demo08ProducerTest {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private Demo08Producer producer;

  @Test
  public void syncSend() throws InterruptedException {
    //不设置消息的过期时间，使用队列默认的消息过期时间
    this.testSyncSendDelay(null);
  }

  private void testSyncSendDelay(Integer delay) throws InterruptedException {
    int id = (int) (System.currentTimeMillis() / 1000);
    producer.syncSend(id, delay);
    logger.info("[testSyncSendDelay][发送编号:[{}]发送成功]", id);
    new CountDownLatch(1).await();
  }

  @Test
  public void testSyncSend() throws InterruptedException {
    this.testSyncSendDelay(5000);
  }


}