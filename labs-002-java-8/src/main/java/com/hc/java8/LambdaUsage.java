package com.hc.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaUsage {

  private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : source) {
      if (predicate.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }

  private static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : source) {
      if (predicate.test(apple.getWeight())) {
        result.add(apple);
      }

    }
    return result;
  }

  private static List<Apple> filterBiPredicate(List<Apple> source,
      BiPredicate<String, Long> predicate) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : source) {
      if (predicate.test(apple.getColor(), apple.getWeight())) {
        result.add(apple);
      }
    }
    return result;
  }

  private static void SimpleTestConsumer(List<Apple> source, Consumer<Apple> consumer) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : source) {
      consumer.accept(apple);
    }
  }

  private static void SimpleTestBiConsumer(String c, List<Apple> source,
      BiConsumer<Apple, String> biConsumer) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : source) {
      biConsumer.accept(apple, c);
    }
  }

  private static String testFunction(Apple apple, Function<Apple, String> fun) {
    return fun.apply(apple);
  }

  private static Apple testBiFunction(String color, long weight,
      BiFunction<String, Long, Apple> biFunction) {
    return biFunction.apply(color, weight);
  }

  public static void main(String[] args) {
//        Runnable r1 = () -> System.out.println("hello");
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello");
//            }
//        };
//        process(r1);
//        process(r2);
//        process(() -> System.out.println("hello"));
    List<Apple> list = Arrays.asList(new Apple("green", 120), new Apple("red", 150));
//        System.out.println(filter(list, apple -> apple.getColor().equals("green")));
//        System.out.println(filterByWeight(list, w -> w > 130));
//        System.out.println(filterBiPredicate(list, (s, l) -> s.equals("green") && l == 120));
//        SimpleTestConsumer(list, a -> System.out.println(a));
//        SimpleTestBiConsumer("green", list, (a, s) -> System.out.println(a));
//        System.out.println(testFunction(new Apple("yellow", 100), apple -> apple.toString()));
//        IntFunction<Double> f = i -> i * 100.0d;
//        System.out.println(f.apply(10));
    //   System.out.println(testBiFunction("blue", 130, (s, w) -> new Apple(s, w)));

    Supplier<String> s = String::new;//method inference 函数推到
    System.out.println(s.get().getClass());
    System.out.println(createApple(() -> new Apple("green", 100)).toString());


  }

  private static Apple createApple(Supplier<Apple> supplier) {
    return supplier.get();
  }

  private static void process(Runnable r) {
    r.run();
  }


}
