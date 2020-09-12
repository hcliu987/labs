package com.hc.springboot.labs.lab10.springdatarediswithjedis.test;

import com.hc.springboot.labs.lab11.springdatarediswithjedis.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class LockTest {
    private static final String LOCK_KEY = "anylock";
    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void test() throws InterruptedException {
        //启动一个线程A，去占有锁
        new Thread(new Runnable() {
            @Override
            public void run() {
                //加锁以后 10秒钟自动解锁
                // 无需调用unlock方法
                final RLock lock = redissonClient.getLock(LOCK_KEY);
                lock.lock(10, TimeUnit.SECONDS);
            }
        }).start();
        //简单sleep 1秒，保证线程a成功持有锁
        Thread.sleep(1000L);
        //尝试加锁，最多等待100秒，上锁以后10秒自动解锁
        System.out.println(String.format("准备开始获得锁时间:%s", new SimpleDateFormat(
                "yyyy-MM-dd hh:mm:ss").format(new Date())));
        final RLock lock = redissonClient.getLock(LOCK_KEY);
        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        if (res) {
            System.out.println(String.format("实际获得锁时间:%s", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())));
        } else {
            System.out.println("加锁失败");
        }


    }
}
