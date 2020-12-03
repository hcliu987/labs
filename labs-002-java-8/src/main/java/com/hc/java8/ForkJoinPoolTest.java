package com.hc.java8;

import com.hc.java8.AccumulatorRecursiveAction.AccumulatorHelper;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {

  private static int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

  public static void main(String[] args) {
    System.out.println(calc());
    AccumulatorRecursiveTask task=new AccumulatorRecursiveTask(0, data.length, data);
    ForkJoinPool forkJoinPool=new ForkJoinPool();
    System.out.println(forkJoinPool.invoke(task));
    AccumulatorRecursiveAction action =new AccumulatorRecursiveAction(0, data.length, data);
    forkJoinPool.invoke(action);
    System.out.println(AccumulatorHelper.getValue());
  }

  private static int calc() {
    int result = 0;
    for (int i = 0; i < data.length; i++) {
      result += data[i];
    }
    return result;
  }
}
