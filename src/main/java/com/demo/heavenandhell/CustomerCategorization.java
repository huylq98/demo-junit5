package com.demo.heavenandhell;

public class CustomerCategorization {


  public String getRankOfCustomer(int type)
  {

    switch (type) {
      case 1:
        return "VIP";
      case 2:
        return "Platinum";
      case 3:
        return "Gold";
      default:
        return "Normal";
    }

  }

}
