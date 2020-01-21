package com.thoughtworks.guessnumber;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Answer {
    private static final int NUMBER_COUNT = 4;

    public String getAnswer() {
        Random random = new Random();
        Set<String> numbers = new LinkedHashSet<>();
        while (numbers.size() < NUMBER_COUNT) {
            int item = random.nextInt(10);
            System.out.println(item);
            numbers.add(String.valueOf(item));
        }

        return String.join("", numbers);
    }
}
