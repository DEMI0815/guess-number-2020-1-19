package com.thoughtworks.guessnumber;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Result {

    private String input;
    private String output;

    @Override
    public String toString() {
        return "Result{" +
                "input='" + input + '\'' +
                ", output='" + output + '\'' +
                '}';
    }
}
