package com.hc.java8;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFind {

  public static void main(String[] args) {
    Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
    Optional<Integer> any = stream.filter(i -> i % 2 == 0).findAny();
    stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
    Optional<Integer> first = stream.filter(integer -> integer % 2 == 0).findFirst();
    System.out.println(any.get());
    System.out.println(first.get());


  }
}
