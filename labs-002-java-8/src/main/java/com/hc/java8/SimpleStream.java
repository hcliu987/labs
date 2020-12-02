package com.hc.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStream {

  public static void main(String[] args) {
    //hava a dish list  (menu)
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

//        System.out.println(getDishNamesByStream(menu));

    Stream<Dish> dishStream = Stream.of(new Dish("prawns", false, 300, Dish.Type.FISH),
        new Dish("salmon", false, 450, Dish.Type.FISH));
    dishStream.forEach(System.out::println);
    List<String> result = menu.stream().filter(d -> {
      System.out.println("filtering->" + d.getName());
      return d.getCalories() > 300;
    }).map(d -> {
      System.out.println("map ->" + d.getName());
      return d.getName();
    }).limit(3).collect(Collectors.toList());
    System.out.println(result);
  }


  private static List<String> getDishNamesByStream(List<Dish> menu) {
    return menu.stream().filter(d -> d.getCalories() < 400)
        .sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName)
        .collect(Collectors.toList());
  }

  private static List<String> getDishNameByCollections(List<Dish> menu) {
    List<Dish> lowCalories = new ArrayList<>();
    for (Dish dish : menu) {
      if (dish.getCalories() < 400) {
        lowCalories.add(dish);
      }
    }
    Collections.sort(lowCalories, (d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()));
    List<String> dishNameList = new ArrayList<>();
    for (Dish d : lowCalories) {
      dishNameList.add(d.getName());
    }
    return dishNameList;
  }
}
