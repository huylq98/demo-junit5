package com.demo.heavenandhell;

import com.demo.heavenandhell.constant.Months;

public class PrintUtility {

  public void printCodeOfMonth(Months month)
  {
    System.out.println("Code is " + month.getMonthCode());
  }

  public void printPriceOfProduct(String productName, String productPrice)
  {
    System.out.println(productName + "has price: " + productPrice + "$");
  }

}
