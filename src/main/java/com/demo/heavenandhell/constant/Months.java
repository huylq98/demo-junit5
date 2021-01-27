package com.demo.heavenandhell.constant;

public enum Months {

  JANUARY(1),
  FEBRUARY(2),
  MARCH(3);

  private final int code;
  private Months(int code)
  {
    this.code = code;
  }

  public int getMonthCode() {
    return this.code;
  }
}
