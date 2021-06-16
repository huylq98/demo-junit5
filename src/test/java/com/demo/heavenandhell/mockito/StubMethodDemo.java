package com.demo.heavenandhell.mockito;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StubMethodDemo {
    @Mock
    List<String> mockList;

    @Test
    public void returnedValueTest() {
        when(mockList.size()).thenReturn(10);
        assertEquals(10, mockList.size());
    }

    @Test
    public void throwMethodTest() {
        // Throw unchecked exceptions
        when(mockList.size()).thenThrow(StackOverflowError.class);
        assertThrows(StackOverflowError.class, () -> mockList.size());

/*
        // If throw checked exceptions
        // -> Must match one of the checked exceptions thrown by stubbed method signature
        when(mockList.get(0)).thenThrow(IndexOutOfBoundsException.class);
        assertThrows(IndexOutOfBoundsException.class, () -> mockList.get(0));
*/
    }

    @Test
    public void returnedMultipleValueTest() {
        // Returned value can be mixed with exceptions
        when(mockList.get(anyInt()))
                .thenReturn("First value")
                .thenThrow(RuntimeException.class)
                .thenReturn("Last value");

        assertAll(() -> {
            assertEquals("First value", mockList.get(2));
            assertThrows(RuntimeException.class, () -> mockList.get(5));

            // The last value/behavior is used for all following calls
            assertEquals("Last value", mockList.get(5));
            assertEquals("Last value", mockList.get(5));
        });
    }

    @Test
    public void voidMethodTest() {
        doThrow(ArithmeticException.class).when(mockList).add(anyInt(), anyString());
        assertThrows(ArithmeticException.class, () -> mockList.add(2, "Random element"));
    }
}
