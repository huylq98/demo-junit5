package com.demo.heavenandhell;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import com.demo.heavenandhell.entity.Car;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertionsDemoTest {


  @Test
  @DisplayName("Test fail compare two cars")
  public void changeOrderOfParams() {
    CarFactory carFactory = new CarFactory();
    //Todo: Junit 4 syntax: message, objectForAssert
    assertNull(carFactory.makeToyota(3), "Có tạo ô tô ko?");
    assertNotNull(carFactory.makeToyota(1), "Tạo đi");

    // Compare two instances
    Car car1 = new Car(4);
    Car car2 = new Car(1);

    assertEquals(car1, car2, "Cùng là 1 xe");

  }

  @Test
  public void someNewAssert() {
    List<Integer> list1 = Arrays.asList(1, 2, 3);
    List<Integer> list2 = list1;
    List<Integer> list3 = Arrays.asList(1, 2, 3);

    int[] array1 = {1, 2, 3};
    int[] array2 = {1, 2, 3};
    int[] array3 = {4, 2, 3};

    List<String> stringList1 = Arrays.asList("1", "2", "3");
    List<String> stringList2 = Arrays.asList("1", "2", "3");
    List<String> stringList3 = Arrays.asList("2", "2", "3");


    // assert Array
    assertArrayEquals(array1, array2, "Giong nhau");
//    assertArrayEquals(array1, array3, "Khac nhau");

    // assert Iterable
    assertIterableEquals(stringList1, stringList2, "Giống nhau");

    // assert reference object
    assertSame(list1, list2, "same instance");
    assertNotSame(list1, list3, "same value but different instances");

    //Todo: compare two List<String>
//    assertLinesMatch(stringList1, stringList2, "Same content");
//    assertLinesMatch(stringList1, stringList3, "Not same content");

  }

  @Test
  public void testTimeOut()
  {
    //This will pass
    assertTimeout(Duration.ofMinutes(1), () -> {
      return "result";
    });

    //This will fail
    assertTimeout(Duration.ofMillis(100), () -> {
      Thread.sleep(200);
      return "result";
    });

    //This will fail. The executable will be aborted once it exceeds the timeout
    assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
      Thread.sleep(200);
      return "result";
    });

  }



}
