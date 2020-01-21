package com.thoughtworks.guessnumber;

import java.util.*;

public class GuessNumber {
    private final String answer;
    private static int numOfInput = 0;
    List<Result> resultList = new ArrayList<>();

    private static final int MAX_INPUT_TIMES = 6;
    private static final int NUMBER_COUNT = 4;

    public static void main(String[] args) {
        Answer answer = new Answer();
        GuessNumber guessNumber = new GuessNumber(answer);
        System.out.println("game start");
        while (numOfInput < MAX_INPUT_TIMES) {
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            List<Result> guess = guessNumber.guess(input);
            guess.forEach(System.out::println);
        }
        System.out.println("game over");
    }

    public GuessNumber(Answer answer) {
        this.answer = answer.getAnswer();
    }

    List<Result> guess(String input) {
        if (numOfInput < MAX_INPUT_TIMES) {
            String output = getOutput(input);
            numOfInput++;
            Result currentResult = new Result(input, output);
            resultList.add(currentResult);
            if (output.equals("4A0B")) {
                numOfInput = MAX_INPUT_TIMES;
                return resultList;
            }
        }
        return resultList;
    }

    String getOutput(String input) {
        if (input.length() > NUMBER_COUNT || input.chars().distinct().count() != NUMBER_COUNT)
            return "Wrong Input, input again";
        int numA = 0;
        int numB = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            char answerChar = answer.charAt(i);
            char inputChar = input.charAt(i);
            if (answer.indexOf(inputChar) != -1) {
                if (answerChar == inputChar)
                    numA++;
                else
                    numB++;
            }
        }

        return numA + "A" + numB + "B";
    }
}
