package com.demo.heavenandhell;

import com.demo.heavenandhell.entity.Car;

public class CarFactory {

  private final int EXPENSIVE = 1;
  private final int CHEAP = 2;
  private final int SECONDHAND = 3;

  public Car makeToyota(int colorCode)
  {
    switch (colorCode)
    {
      case 1:
        return new Car("Toyota", "Red");
      case 2:
        return new Car("Toyota", "Blue");
      default:
        return null;
    }
  }


  public int rateCar(int carId)
  {
    switch (carId)
    {
      case 1: return EXPENSIVE;
      case 2: return CHEAP;
      default: return SECONDHAND;
    }
  }

}
