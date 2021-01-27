package com.demo.heavenandhell;

public class MathUtility {

  public long multiply (int a , int b)
  {
    return a * b;
  }

  public float divide (int a, int b)
  {
    if(b != 0)
      return a/b;
    else
      throw new IllegalArgumentException();
  }

  public void printSomething(String something)
  {
    System.out.println(something);
  }

}
