package com.github.agheorghies.fizzbuzz;

public class Application {
    public static final String RUN_APP_CMD = "java -jar target/fizzbuzz-1.0-SNAPSHOT-jar-with-dependencies.jar";
    public static final String BEGIN_ARGUMENT = "begin";
    public static final String END_ARGUMENT = "end";

    public static void printUsage() {
        System.out.println("\nUsage:\n" + RUN_APP_CMD + " " + BEGIN_ARGUMENT + " " + END_ARGUMENT);
        System.out.println("\nExample:\n"+ RUN_APP_CMD + " 1 20");
    }

    public static int parseIntArgument(String argumentStr, String argumentName) throws RuntimeException {
        try {
            return Integer.valueOf(argumentStr);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid argument: " + argumentName);
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                throw new RuntimeException("Invalid number of arguments.");
            }

            int begin = parseIntArgument(args[0], BEGIN_ARGUMENT);
            int end  = parseIntArgument(args[1], END_ARGUMENT);

            FizzBuzzRange fizzBuzzRange = new FizzBuzzRange();
            fizzBuzzRange.printRange(begin, end, System.out);
            fizzBuzzRange.printReport(begin, end, System.out);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            printUsage();
        }
    }
}
