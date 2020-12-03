package com.hc.java8;

public class DefaultInAction {
  private void confuse(Object o) {
    System.out.println("object");
  }

  private void confuse(int[] i) {
    System.out.println("int");
  }

  public static void main(String[] args) {

   A c=new c();
   c.hello();
  }

  private interface A {
    default void hello() {
      System.out.println("a hello");
    }
  }
  private interface  B extends A{

    @Override
    default void hello() {
      System.out.println("b hello");
    }
  }
  private static class  c implements  B,A{

    @Override
    public void hello() {
      B.super.hello();
    }
  }
}
