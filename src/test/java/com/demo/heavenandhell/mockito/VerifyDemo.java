package com.demo.heavenandhell.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VerifyDemo {
    @Mock
    List<String> mockList;

    @Captor
    ArgumentCaptor<String> captor;

    @Test
    public void verifyArgsMatchingTest() {
        mockList.add("CBR650");

/*
        // ONLY one method can be captured at a time
        // if add many times -> capture fails
        mockList.add("R1");
*/

        // verify and store argument value in captor
        // one method can be verified many times
        // capture many times -> store captured values in List<String>
        verify(mockList).add(captor.capture());
        verify(mockList).add(captor.capture());

        Assertions.assertEquals(
                Arrays.asList("CBR650", "CBR650"),
                captor.getAllValues());
/*
        // not verified
        verify(mockList).add("Z1000");
*/
    }

    @Test
    public void verifyMethodCallTimesTest() {
        mockList.add(anyString());
        mockList.size();
        mockList.size();
        mockList.remove(1);

        // fixed call times
        verify(mockList, times(2)).size();

        // call at least n times
        verify(mockList, atLeastOnce()).add(anyString());
        verify(mockList, atLeast(1)).size();

        // call at most n times
        verify(mockList, atMostOnce()).remove(anyInt());
        verify(mockList, atMost(10)).size();

        // never call
        verify(mockList, never()).get(anyInt());

/*
        // check any UNVERIFIED interactions
        mockList.set(anyInt(), anyString());
        verifyNoMoreInteractions(mockList);
*/

/*
        // no interactions happened on given mock BEFORE this method
        verifyNoInteractions(mockList);
*/
    }

    @Test
    public void verifyInOrderTest() {
        InOrder inOrder = inOrder(mockList);

        // Have to đợi vợ đi khỏi nhà first
        mockList.remove("Đợi vợ đi khỏi nhà");
        mockList.add("Thêm em Huệ vào giỏ hàng");
        mockList.add("Thêm em Huệ vào giỏ hàng");
        mockList.add("Thêm em Huệ vào giỏ hàng");
        mockList.add("Thêm em Mai vào giỏ hàng");

/*
        // Add em Huệ before đợi vợ đi khỏi nhà -> Wrong order
        inOrder.verify(mockList).add("Thêm em Huệ vào giỏ hàng");
        inOrder.verify(mockList).remove("Đợi vợ đi khỏi nhà");
*/

        inOrder.verify(mockList).remove("Đợi vợ đi khỏi nhà");

        // calls will not fail if add em Huệ three times
        // but only verify the first & the second time add em Huệ
        // the third time will not be verified
        inOrder.verify(mockList, calls(2)).add("Thêm em Huệ vào giỏ hàng");

        // times will fail if add em Mai many times
        inOrder.verify(mockList, times(1)).add("Thêm em Mai vào giỏ hàng");

/*
        // this will fail because the third time add em Huệ was not verified
        verifyNoMoreInteractions(mockList);
*/
    }

    @Test
    public void verifyTimeoutTest() throws InterruptedException {
        // verify will be trigger over and over util timeout
        // useful when interactions not happen yet
        final Thread t1 = new Thread(() -> verify(mockList, timeout(100)).add(anyString()));


        final Thread t2 = new Thread(() -> {
            sleep(50);
            mockList.add(anyString());
        });

        t1.start();

        // assure t1 to start first
        sleep(10);

        t2.start();

        // waits t1 & t2 to die
        t1.join();
        t2.join();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
