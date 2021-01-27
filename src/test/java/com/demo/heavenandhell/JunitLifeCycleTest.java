package com.demo.heavenandhell;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class JunitLifeCycleTest {

  @BeforeAll
  public static void runOneTimeBeforeRunAll()
  {
    System.out.println("runOneTimeBeforeRunAll");
  }


  // setup
  @BeforeEach
  public void runEachTimeBeforeEachTestCase()
  {
    System.out.println("runBeforeEachTestCase");
  }


  // tearDown
  @AfterEach
  public void runEachTimeAfterEachTestCase()
  {
    System.out.println("runAfterEachTestCase");
  }

  @AfterAll
  public static void runOneTimeAfterRunAll()
  {
    System.out.println("runOneTimeAfterRunAll");
  }

  @Test
  public void testSomething()
  {
    System.out.println("Wow");
  }

  @Test
  @RepeatedTest(2)
  public void testClick()
  {
    System.out.println("Click Me");
  }

  @Disabled
  public void notYetComplete()
  {
    System.out.println("Don't run me!");
  }

}
