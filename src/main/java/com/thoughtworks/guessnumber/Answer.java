package com.thoughtworks.guessnumber;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Answer {
    public String getAnswer() {
        Random random = new Random();
        Set<String> numbers = new HashSet<>();
        while (numbers.size() < 4) {
            numbers.add(String.valueOf(random.nextInt(10)));
        }
        return String.join("", numbers);
    }
}
