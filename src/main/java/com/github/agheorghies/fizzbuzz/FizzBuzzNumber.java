package com.github.agheorghies.fizzbuzz;

public class FizzBuzzNumber {
    public static final String FIZZ_BUZZ = "fizzbuzz";
    public static final String FIZZ = "fizz";
    public static final String BUZZ = "buzz";
    public static final String THREE = "three";
    public static final String INTEGER = "integer";

    public static String mapNumber(int number) {
        return map(number, false);
    }

    public static String mapGroup(int number) {
        return map(number, true);
    }

    private static String map(int number, boolean toGroup) {
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

        if (toGroup) {
            return INTEGER;
        }

        return value;
    }
}
