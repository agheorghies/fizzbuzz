package com.github.agheorghies.fizzbuzz.service.impl;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.github.agheorghies.fizzbuzz.service.impl.FizzBuzzNumber.BUZZ;
import static com.github.agheorghies.fizzbuzz.service.impl.FizzBuzzNumber.FIZZ;
import static com.github.agheorghies.fizzbuzz.service.impl.FizzBuzzNumber.FIZZ_BUZZ;
import static com.github.agheorghies.fizzbuzz.service.impl.FizzBuzzNumber.INTEGER;
import static com.github.agheorghies.fizzbuzz.service.impl.FizzBuzzNumber.THREE;

public class FizzBuzzRange {

    public static final String DELIMITER = " ";
    public static final String REPORT_ITEM_DELIMITER = ": ";

    public List<String> mapRange(int begin, int end) {
        if (begin > end) {
            return Collections.emptyList();
        }

        return IntStream
                .rangeClosed(begin, end)
                .mapToObj(FizzBuzzNumber::mapNumber)
                .collect(Collectors.toList());
    }

    public void printRange(int begin, int end, PrintStream out) {
        out.println(
                mapRange(begin, end)
                        .stream()
                        .collect(Collectors.joining(DELIMITER))
        );
    }

    public Map<String, Long> mapRangeByGroups(int begin, int end) {
        if (begin > end) {
            return Collections.emptyMap();
        }

        return  IntStream
                .rangeClosed(begin, end)
                .mapToObj(FizzBuzzNumber::mapGroup)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public String getReportItem (String group, Long count) {
        if (count == null) {
            count = 0L;
        }

        return group + REPORT_ITEM_DELIMITER + count;
    }

    public void printReport(int begin, int end, PrintStream out) {
        List<String> groups = Arrays.asList(FIZZ, BUZZ, FIZZ_BUZZ, THREE, INTEGER);

        Map<String, Long> items = mapRangeByGroups(begin, end);

        out.println(
                groups.stream()
                        .map(group -> getReportItem(group , items.get(group) ))
                        .collect(Collectors.joining(DELIMITER))
        );
    }
}
