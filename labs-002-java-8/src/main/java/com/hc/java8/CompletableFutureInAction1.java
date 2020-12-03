package com.hc.java8;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureInAction1 {
  private static final Random RANDOM = new Random(System.currentTimeMillis());

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFuture<Double> completableFuture = new CompletableFuture();
    new Thread(() -> {
      double value = get();
      completableFuture.complete(value);
    }).start();
    System.out.println("=====no=====block....");
    Optional.ofNullable(completableFuture.get()).ifPresent(System.out::println);
  }

  static double get() {
    try {
      Thread.sleep(RANDOM.nextInt(10000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    double result = RANDOM.nextDouble();
    System.out.println(result);
    return result;
  }
}
