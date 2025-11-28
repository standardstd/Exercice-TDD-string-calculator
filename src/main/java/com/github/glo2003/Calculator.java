package com.github.glo2003;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        Pattern pattern = Pattern.compile("^(\\d*((\\s)*,(\\s)*\\d*)*)?$");
        Matcher matcher = pattern.matcher(numbers);
        String[] numberArray;

        if (matcher.matches()) {
            numberArray = numbers.split(",");
            return Arrays.stream(numberArray)
                    .map(String::trim)
                    .map(Calculator::voidToZero)
                    .map(Integer::parseInt)
                    .reduce(0, Integer::sum);
        }
        throw new InvalidNumberFormatException();
    }

    private static String voidToZero(String number) {
        if (number.isEmpty()) {
            return "0";
        }
        return number;
    }

}
