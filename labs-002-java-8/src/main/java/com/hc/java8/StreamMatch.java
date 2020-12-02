package com.hc.java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMatch {

  public static void main(String[] args) {
    Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    System.out.println(stream.allMatch(i -> i < 0));
    stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    System.out.println(stream.anyMatch(i -> i > 10));

  }
}
