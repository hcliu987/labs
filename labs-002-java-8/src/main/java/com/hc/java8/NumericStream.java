package com.hc.java8;

import java.util.stream.IntStream;

public class NumericStream {

  public static void main(String[] args) {
//        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
//        IntStream intStream = stream.filter(i -> i.intValue() > 3).mapToInt(i -> i.intValue());
//        System.out.println(intStream.filter(i -> i > 3).sum());

    int a = 9;
    //1...1000
    IntStream.rangeClosed(1, 1000)
        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
        .boxed()
        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
        .forEach(r -> System.out.println("a=" + r[0] + "b=" + r[1] + "c=" + r[2]));
    IntStream.rangeClosed(1, 100)
        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
        .forEach(r -> System.out.println("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]));
  }

}
