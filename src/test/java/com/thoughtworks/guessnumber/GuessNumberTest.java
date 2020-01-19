package com.thoughtworks.guessnumber;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessNumberTest {

    @Test
    public void should_return_all_right() {
        Answer answer = mock(Answer.class);
        when(answer.getAnswer()).thenReturn("1234");
        GuessNumber guessNumber = new GuessNumber(answer);

        String output = guessNumber.getOutput("1234");

        assertEquals(output, "4A0B");
    }

}