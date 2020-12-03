package com.hc.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTest {
  public static void main(String[] args) {
    //
    combineLocalDataAndTime();
  }

  private static void testLocalDate() {
    LocalDate localDate = LocalDate.of(2020, 12, 3);
    System.out.println(localDate.getYear());
    System.out.println(localDate.getMonth());
    System.out.println(localDate.getMonthValue());
    System.out.println(localDate.getDayOfYear());
    System.out.println(localDate.getDayOfMonth());
    System.out.println(localDate.getDayOfWeek());
  }

  private static void testLocalDateTime() {
    LocalTime time = LocalTime.now();
    System.out.println(time.getHour());
    System.out.println(time.getMinute());
  }

  private static void combineLocalDataAndTime() {
    LocalDate now = LocalDate.now();
    LocalTime time = LocalTime.now();
    LocalDateTime localDateTime = LocalDateTime.of(now, time);
    System.out.println(localDateTime.toString());

  }
}
