package com.github.agheorghies.fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static final String FIZZ_BUZZ = "fizzbuzz";
    public static final String FIZZ = "fizz";
    public static final String BUZZ = "buzz";
    public static final String THREE = "three";
    public static final String DELIMITER = " ";

    public static String mapNumber(int number) {
        String value = String.valueOf(number);

        if (value.contains("3")) {
            return THREE;
        }

        if (number % 15 == 0) {
            return FIZZ_BUZZ;
        }

        if (number % 3 == 0) {
            return FIZZ;
        }

        if (number % 5 == 0) {
            return BUZZ;
        }

        return value;
    }

    public static String mapRange(int begin, int end) {
        if (begin > end) {
            return "";
        }

        return IntStream
                .rangeClosed(begin, end)
                .mapToObj(FizzBuzz::mapNumber)
                .collect(Collectors.joining(DELIMITER));
    }
}
