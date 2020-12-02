package com.hc.java8;

import java.util.Arrays;
import java.util.List;

public class StreamMap {

  public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 1);
//        System.out.println(list.stream().map(i -> i * 2).collect(Collectors.toList()));
//        System.out.println(listDish().stream().map(d -> d.getName()).collect(Collectors.toList()));
    //flatmap flat 扁平化
    String[] words = {"hello", "world"};
    Arrays.stream(words).map(w -> w.split("")).flatMap(Arrays::stream).distinct()
        .forEach(System.out::println);
  }

  private static List<Dish> listDish() {
    List<Dish> menu = Arrays.asList(
        new Dish("pork", false, 800, Dish.Type.MEAT),
        new Dish("beef", false, 700, Dish.Type.MEAT),
        new Dish("chicken", false, 400, Dish.Type.MEAT),
        new Dish("french fries", true, 530, Dish.Type.OTHER),
        new Dish("rice", true, 350, Dish.Type.OTHER),
        new Dish("season fruit", true, 120, Dish.Type.OTHER),
        new Dish("pizza", true, 550, Dish.Type.OTHER),
        new Dish("prawns", false, 300, Dish.Type.FISH),
        new Dish("salmon", false, 450, Dish.Type.FISH));
    return menu;
  }
}
