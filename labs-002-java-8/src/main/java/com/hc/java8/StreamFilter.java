package com.hc.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 1);
    List<Integer> result = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
    System.out.println(result);
    System.out.println(list.stream().distinct().collect(Collectors.toList()));
    System.out.println(list.stream().skip(5).collect(Collectors.toList()));
    System.out.println(list.stream().limit(5).collect(Collectors.toList()));

  }
}
