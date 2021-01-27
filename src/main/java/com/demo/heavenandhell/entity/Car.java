package com.demo.heavenandhell.entity;

public class Car {

  private int id;
  private String branchName;
  private String color;

  public Car() {
  }

  public Car(int id) {
    this.id = id;
  }

  public Car(String branchName, String color) {
    this.branchName = branchName;
    this.color = color;
  }

  public String getBranchName() {
    return branchName;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
