package com.thoughtworks.guessnumber;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnswerTest {

    @Test
    public void should_return_4_int() {
        Answer answer = new Answer();
        String answerString = answer.getAnswer();

        assertEquals(answerString.length(), 4);
    }

    @Test
    public void should_return_non_repeat() {
        Answer answer = new Answer();
        String answerString = answer.getAnswer();

        Set<Character> numbers = new HashSet<>();
        for ( int i = 0; i < answerString.length(); i++) {
            numbers.add(answerString.charAt(i));
        }
        boolean isNonRepeat = numbers.size() == answerString.length();

        assertTrue(isNonRepeat);
    }

}