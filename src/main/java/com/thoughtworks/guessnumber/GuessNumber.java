package com.thoughtworks.guessnumber;

import java.util.*;

public class GuessNumber {
    private final String answer;
    private static int numOfInput = 0;
    List<Result> resultList = new ArrayList<>();

    public static void main(String[] args) {
        Answer answer = new Answer();
        GuessNumber guessNumber = new GuessNumber(answer);
        while (numOfInput < 6) {
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
        if (numOfInput < 6) {
            String output = getOutput(input);
            numOfInput++;
            Result currentResult = new Result(input, output);
            resultList.add(currentResult);
            if (output.equals("4A0B")) {
                numOfInput = 6;
                return resultList;
            }
        }
        return resultList;
    }

    String getOutput(String input) {
        if (input.length() > 4 || input.chars().distinct().count() != 4)
            return "Wrong Input, input again";
        if (input.equals(answer))
            return "4A0B";
        int numA = 0;
        int numB = 0;
        for (int i = 0; i < 4; i++) {
            char answerChar = answer.charAt(i);
            char inputChar = input.charAt(i);
            if (answerChar == inputChar)
                numA++;
            if (answer.indexOf(inputChar) != -1)
                numB++;
        }
        numB -= numA;

        return numA + "A" + numB + "B";
    }

}

class Answer {
    public String getAnswer() {
        Random random = new Random();
        Set<String> numbers = new HashSet<>();
        while (numbers.size() < 4) {
            numbers.add(String.valueOf(random.nextInt(10)));
        }
        return String.join("", numbers);
    }
}
