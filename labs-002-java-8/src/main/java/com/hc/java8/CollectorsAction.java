package com.hc.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectorsAction {

  public static List<Dish> menu = Arrays.asList(
      new Dish("pork", false, 800, Dish.Type.MEAT),
      new Dish("beef", false, 700, Dish.Type.MEAT),
      new Dish("chicken", false, 400, Dish.Type.MEAT),
      new Dish("french fries", true, 530, Dish.Type.OTHER),
      new Dish("rice", true, 350, Dish.Type.OTHER),
      new Dish("season fruit", true, 120, Dish.Type.OTHER),
      new Dish("pizza", true, 550, Dish.Type.OTHER),
      new Dish("prawns", false, 300, Dish.Type.FISH),
      new Dish("salmon", false, 450, Dish.Type.FISH));

  public static void main(String[] args) {
    testAveragingDouble();
    testAveragingInt();
    testAveragingIntLong();
    testCollectingAndThen();
    testCounting();
    testGroupingByFunction();

    testGroupingByFunctionAndCollector();
    testGroupingByFunctionAndSupplierAndCollector();
    testSummarizingInt();
  }

  private static void testGroupingByFunction() {
    System.out.println("testGroupingByFunction");
    Optional.of(menu.stream().collect(Collectors.groupingBy(Dish::getType)))
        .ifPresent(System.out::println);

  }

  private static void testGroupingByFunctionAndSupplierAndCollector() {
    System.out.println("testGroupingByFunctionAndSupplierAndCollector");
    TreeMap<Dish.Type, Double> map = menu.stream().collect(Collectors
        .groupingBy(Dish::getType, TreeMap::new, Collectors.averagingInt(Dish::getCalories)));
    Optional.of(map.getClass()).ifPresent(System.out::println);
    Optional.of(map).ifPresent(System.out::println);

  }

  private static void testGroupingByFunctionAndCollector() {
    System.out.println("testGroupingByFunctionAndCollector");
    Optional.of(menu.stream()
        .collect(Collectors.groupingBy(Dish::getType, Collectors.averagingInt(Dish::getCalories))))
        .ifPresent(System.out::println);
  }

  private static void testCollectingAndThen() {
    System.out.println("testCollectingAndThen");
    Optional.ofNullable(menu.stream().collect(Collectors
        .collectingAndThen(Collectors.averagingInt(Dish::getCalories),
            a -> "The Average Calories is->" + a)))
        .ifPresent(System.out::println);
    List<Dish> list = menu.stream().filter(d -> d.getType().equals(Dish.Type.MEAT))
        .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    list.add(new Dish("", false, 100, Dish.Type.OTHER));
    System.out.println(list);
  }

  private static void testAveragingIntLong() {
    System.out.println("testAveragingIntLong");
    Optional.ofNullable(menu.stream().collect(Collectors.averagingLong(Dish::getCalories)))
        .ifPresent(System.out::println);
  }

  private static void testCounting() {
    System.out.println("testCounting");
    Optional.ofNullable(menu.stream().collect(Collectors.counting()))
        .ifPresent(System.out::println);
  }

  private static void testAveragingInt() {
    System.out.println("testAveragingInt");
    Optional.ofNullable(menu.stream().collect(Collectors.averagingInt(Dish::getCalories)))
        .ifPresent(System.out::println);
  }

  private static void testAveragingDouble() {
    System.out.println("testAveragingDouble");
    Optional.ofNullable(menu.stream().collect(Collectors.averagingDouble(Dish::getCalories)))
        .ifPresent(System.out::println);
  }

  private static void testSummarizingInt() {
    System.out.println("testSummarizingInt");
    IntSummaryStatistics result = menu.stream()
        .collect(Collectors.summarizingInt(Dish::getCalories));
    Optional.of(result).ifPresent(System.out::println);
  }
}
