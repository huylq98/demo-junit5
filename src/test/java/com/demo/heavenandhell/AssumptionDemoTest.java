package com.demo.heavenandhell;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AssumptionDemoTest {

  @Test
  void onlyRunIfDeployOnWindow()
  {
    Assumptions.assumeTrue(System.getProperty("os.name").contains("Linux"));
//    Assumptions.assumeTrue(System.getProperty("os.name").contains("Window"));
    System.out.println("I'm window");
    assertEquals(5 + 2, 7);
  }

}
