package com.demo.heavenandhell;

import static org.junit.Assert.assertEquals;

import com.demo.heavenandhell.constant.Months;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTestDemoTest {


  public static int[][] createData() {
    return new int[][] { { 1, 2, 2 }, { 5, 0, 0 }, { 3, 3, 9 } };
  }

  @BeforeEach
  void setup()
  {
    System.out.println("BeforeEach");
  }

  @AfterEach
  void tearDown()
  {
    System.out.println("AfterEach");
  }


  /*
    @BeforeEach and @AfterEach methods will be called for parameterized tests
   */
  @ParameterizedTest
  @MethodSource(value = "createData")
  void testUseTestDataFromMethod(int[] data)
  {
    MathUtility mathUtility = new MathUtility();
    int m1 = data[0];
    int m2 = data[1];
    int expected = data[2];
    assertEquals(expected, mathUtility.multiply(m1, m2));
  }

  @ParameterizedTest
  @ValueSource(strings = {"1", "2", "3"})
  void testUseTestDataFromValueSource(String data)
  {
    MathUtility mathUtility = new MathUtility();
    mathUtility.printSomething(data);
  }


  @ParameterizedTest
  @EnumSource(value = Months.class, names = {"FEBRUARY", "MARCH"})
  void testUseTestDataFromEnumSource(Months month)
  {
    PrintUtility printUtility = new PrintUtility();
    printUtility.printCodeOfMonth(month);
  }

  @ParameterizedTest
  @CsvSource({ "Mazda CX5, 200", "Vin Luxury, 300" })
  void testUseTestDataFromCsvSource(String productName, String productPrice)
  {
    PrintUtility printUtility = new PrintUtility();
    printUtility.printPriceOfProduct(productName, productPrice);
  }
}
