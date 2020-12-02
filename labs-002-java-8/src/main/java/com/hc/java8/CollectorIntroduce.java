package com.hc.java8;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorIntroduce {

  public static void main(String[] args) {
    List<Apple> list = Arrays.asList(new Apple("green", 150)
        , new Apple("yellow", 120)
        , new Apple("green", 170)
        , new Apple("green", 150)
        , new Apple("yellow", 120)
        , new Apple("green", 170));
    List<Apple> green = list.stream().filter(apple -> apple.getColor().equals("green"))
        .collect(Collectors.toList());
    Optional.ofNullable(green).ifPresent(System.out::println);
    Optional.ofNullable(groupByNormal(list)).ifPresent(System.out::println);
    System.out.println("===================================================");
    Optional.ofNullable(groupByFunction(list)).ifPresent(System.out::println);
    System.out.println("===================================================");
    Optional.ofNullable(groupByCollector(list)).ifPresent(System.out::println);
  }

  private static Map<String, List<Apple>> groupByNormal(List<Apple> apples) {
    HashMap<String, List<Apple>> map = new HashMap<>();

    for (Apple apple : apples) {
      List<Apple> list = map.get(apple.getColor());
      if (null == list) {
        list = new ArrayList<>();
        map.put(apple.getColor(), list);
      }
      list.add(apple);
    }
    return map;
  }

  private static Map<String, List<Apple>> groupByFunction(List<Apple> apples) {
    HashMap<String, List<Apple>> map = new HashMap<>();
    apples.parallelStream().forEach(a -> {
      List<Apple> colorList = Optional.ofNullable(map.get(a.getColor())).orElseGet(() -> {
        List<Apple> list = new ArrayList<>();
        map.put(a.getColor(), list);
        return list;
      });
      colorList.add(a);
    });
    return map;
  }

  private static Map<String, List<Apple>> groupByCollector(List<Apple> apples) {
    return apples.parallelStream().collect(groupingBy(Apple::getColor));
  }
}
