package com.hc.java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamReduce {

  public static void main(String[] args) {
    Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    System.out.println(stream.reduce(0, (i, j) -> i + j));
    stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    stream.reduce((i, j) -> i + j).ifPresent(System.out::println);
    stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    stream.reduce((i, j) -> {
      return i > j ? i : j;
    }).ifPresent(System.out::println);
    stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    stream.reduce(Integer::max).ifPresent(System.out::println);

  }
}
