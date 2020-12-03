package com.hc.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureInAction3 {
  public static void main(String[] args) {
    ExecutorService executorService =
        Executors.newFixedThreadPool(
            2,
            r -> {
              Thread thread = new Thread();
              thread.setDaemon(false);
              return thread;
            });
    //    CompletableFuture.supplyAsync(CompletableFutureInAction1::get,executorService)
    //        .thenApply(CompletableFutureInAction3::multiply)
    //        .whenComplete((v,t) -> Optional.ofNullable(v).ifPresent(System.out::println));
    List<Integer> productionIDs = Arrays.asList(1, 2, 3, 4, 5);
    Stream<CompletableFuture<Double>> completableFutureStream =
        productionIDs.stream()
            .map(i -> CompletableFuture.supplyAsync(() -> queryProduction(i), executorService));
    Stream<CompletableFuture<Double>> multiplyFutures =
        completableFutureStream.map(
            future -> future.thenApply(CompletableFutureInAction3::multiply));
    System.out.println(multiplyFutures.map(CompletableFuture::join).collect(Collectors.toList()));
  }

  private static double multiply(double value) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return value * 10d;
  }

  private static double queryProduction(int i) {
    return CompletableFutureInAction1.get();
  }
}
