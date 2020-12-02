package com.hc.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomerCollectorAction {

  public static void main(String[] args) {
    Collector<String, List<String>, List<String>> collector = new ToListCollector<>();
    String[] arrs = new String[]{"Alex", "Wang", "Hello", "Lambda", "Collector", "Java 8",
        "Stream"};
    List<String> collect = Arrays
        .asList("Alex", "Wang", "Hello", "Lambda", "Collector", "Java 8", "Stream")
        .parallelStream()
        .filter(s -> s.length() >= 5)
        .collect(Collectors.toList());
    System.out.println(collect);
  }

}
