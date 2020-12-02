package com.hc.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReference {

  public static void main(String[] args) {
//        Consumer<String> consumer = s -> System.out.println(s);
//        useConsumer(consumer, "hello alex");
//        useConsumer(s -> System.out.println(s), "hello,world");
//        useConsumer(System.out::println, "hello,likai");
    List<Apple> list = Arrays
        .asList(new Apple("abc", 110), new Apple("Red", 123), new Apple("Green", 123));
    System.out.println(list);
    list.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));
    list.stream().forEach(System.out::println);
    list.stream().forEach(a -> System.out.println(a));
    ThreeFunction<String, Long, String, ComplexApple> threeFunction = ComplexApple::new;

  }

  private static <T> void useConsumer(Consumer<T> consumer, T t) {
    consumer.accept(t);
    consumer.accept(t);
  }
}
