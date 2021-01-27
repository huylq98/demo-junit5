package com.demo.heavenandhell;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class DynamicTestDemoTest {


  /*
   - @BeforeEach and @AfterEach methods will not be called for dynamic tests.
   - The factory method must return a Stream, Collection, Iterable, or Iterator.
   - @TestFactory methods must not be private or static.
   */

  @TestFactory
  public Stream<DynamicTest> testMultiply() {
    MathUtility mathUtility = new MathUtility();
    int[][] testData = new int[][] { { 1, 2, 2 }, { 5, 0, 0 }, { 3, 3, 9 } };

    return Arrays.stream(testData).map(entry -> {
      int m1 = entry[0];
      int m2 = entry[1];
      int expected = entry[2];
      return dynamicTest(m1 + " * " + m2 + " = " + expected, () -> {
        assertEquals(expected, mathUtility.multiply(m1, m2));
      });
    });
  }
}
