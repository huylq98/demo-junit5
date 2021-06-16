package com.demo.heavenandhell.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnswerDemo {
    @Mock
    ArrayList<String> mockList;

    @Test
    public void preConfiguredAnswerTest() {
        // call real size() method
        // mockList is empty -> size() returns 0
        when(mockList.size()).thenAnswer(Answers.CALLS_REAL_METHODS);

        assertEquals(0, mockList.size());
    }

    @Test
    public void customAnswerTest() {
        final Answer<Integer> customAnswer = invocation -> {
            // trigger if invoked method has 1 param
            if (invocation.getMethod().getParameterCount() == 1) {
                return invocation.getArgument(0, Integer.class) * 2;
            }

            // invoked method has 0 or many params
            return 123;
        };

        // 1 param
        when(mockList.get(10)).thenAnswer(customAnswer);
        when(mockList.remove(5)).thenAnswer(customAnswer);

        // 0 param
        when(mockList.size()).thenAnswer(customAnswer);

        // many params
        when(mockList.set(eq(1), anyString())).thenAnswer(customAnswer);

        assertEquals(20, mockList.get(10));
        assertEquals(10, mockList.remove(5));
        assertEquals(123, mockList.size());
        assertEquals(123, mockList.set(1, "random string"));
    }
}
