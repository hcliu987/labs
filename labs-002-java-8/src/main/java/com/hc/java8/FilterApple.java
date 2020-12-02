package com.hc.java8;

import java.util.ArrayList;
import java.util.List;

public class FilterApple {

  public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {
    List<Apple> list = new ArrayList<Apple>();
    for (Apple apple : apples) {
      if (appleFilter.filter(apple)) {
        list.add(apple);
      }

    }
    return list;
  }

  public static List<Apple> findGreenApple(List<Apple> apples) {
    List<Apple> list = new ArrayList<Apple>();

    for (Apple apple : apples) {
      if ("green".equals(apple.getColor())) {
        list.add(apple);
      }

    }
    return list;
  }

  public static List<Apple> findApple(List<Apple> apples, String color) {
    List<Apple> list = new ArrayList<Apple>();
    for (Apple apple : apples) {
      if (color.equals(apple.getColor())) {
        list.add(apple);
      }

    }
    return list;
  }

  public static void main(String[] args) throws InterruptedException {
//        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yello", 120), new Apple("green", 170));
//        List<Apple> greenAppless = findGreenApple(list);
//        assert greenAppless.size() == 2;
//        List<Apple> apples = findApple(list, (Apple apple) -> {
//            return apple.getColor().equals("green");
//        });
//        System.out.println(apples);
    new Thread(new Runnable() {

      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName());
      }
    }).start();
    new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    Thread.currentThread().join();
  }

  public interface AppleFilter {

    boolean filter(Apple apple);
  }

  public static class GreenAnd150WeightFilter implements AppleFilter {

    @Override
    public boolean filter(Apple apple) {
      return (apple.getColor().equals("green") && apple.getWeight() >= 150);
    }
  }


}