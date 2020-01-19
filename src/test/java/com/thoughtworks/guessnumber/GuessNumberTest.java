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

    @Test
    public void should_return_1A0B() {
        Answer answer = mock(Answer.class);
        when(answer.getAnswer()).thenReturn("1234");
        GuessNumber guessNumber = new GuessNumber(answer);

        String output = guessNumber.getOutput("1567");

        assertEquals(output, "1A0B");
    }

    @Test
    public void should_return_0A2B() {
        Answer answer = mock(Answer.class);
        when(answer.getAnswer()).thenReturn("1234");
        GuessNumber guessNumber = new GuessNumber(answer);

        String output = guessNumber.getOutput("2478");

        assertEquals(output, "0A2B");
    }

    @Test
    public void should_return_1A2B() {
        Answer answer = mock(Answer.class);
        when(answer.getAnswer()).thenReturn("1234");
        GuessNumber guessNumber = new GuessNumber(answer);

        String output = guessNumber.getOutput("0324");

        assertEquals(output, "1A2B");
    }

    @Test
    public void wrong_input_when_repetition() {
        Answer answer = mock(Answer.class);
        when(answer.getAnswer()).thenReturn("1234");
        GuessNumber guessNumber = new GuessNumber(answer);

        String output = guessNumber.getOutput("1123");

        assertEquals(output, "Wrong Input, input again");
    }

}