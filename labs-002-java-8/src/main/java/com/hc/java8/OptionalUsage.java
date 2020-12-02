package com.hc.java8;

import java.util.Optional;

public class OptionalUsage {

  public static void main(String[] args) {
    Optional<Insurance> insuranceOptional = Optional.<Insurance>empty();
    System.out.println(insuranceOptional.get());
    Optional<Insurance> insurance = Optional.of(new Insurance());
    System.out.println(insurance.get());

    System.out.println(getInsuranceName(null));
    System.out.println(getInsuranceNameByOptional(null));
  }

  private static String getInsuranceName(Insurance insurance) {
    if (null == insurance) {
      return "unknow";
    }
    return insurance.getName();
  }

  private static String getInsuranceNameByOptional(Insurance insurance) {
    return Optional.ofNullable(insurance).map(Insurance::getName).orElse("unknow");
  }
}
