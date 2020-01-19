package com.thoughtworks.guessnumber;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GuessNumber {
    private final String answer;

    public GuessNumber(Answer answer) {
        this.answer = answer.getAnswer();
    }

    String getOutput(String input) {
        if (input.equals(answer))
            return "4A0B";
        return "";
    }

}

class Answer {
    public String getAnswer() {
        Random random = new Random();
        Set<String> numbers = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            numbers.add(String.valueOf(random.nextInt(10)));
        }
        return String.join("", numbers);
    }
}
