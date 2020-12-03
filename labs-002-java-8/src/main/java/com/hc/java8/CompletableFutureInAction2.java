package com.hc.java8;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class CompletableFutureInAction2 {
  public static void main(String[] args) throws InterruptedException {
//    AtomicBoolean finished = new AtomicBoolean(false);
//    CompletableFuture.supplyAsync(CompletableFutureInAction1::get)
//        .whenComplete(
//            (v, t) -> {
//              Optional.of(v).ifPresent(System.out::println);
//              Optional.of(t).ifPresent(x -> x.printStackTrace());
//            });
//    System.out.println("=== i am  no ---block----");
//    Thread.currentThread().join();
//    while (!finished.get()) {
//      Thread.sleep(1);
//    }
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.execute(() -> System.out.println("test"));
  }
}
