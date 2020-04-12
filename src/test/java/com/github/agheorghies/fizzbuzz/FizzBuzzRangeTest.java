package com.github.agheorghies.fizzbuzz;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.github.agheorghies.fizzbuzz.FizzBuzzNumber.THREE;
import static com.github.agheorghies.fizzbuzz.FizzBuzzNumber.BUZZ;
import static com.github.agheorghies.fizzbuzz.FizzBuzzNumber.FIZZ;
import static com.github.agheorghies.fizzbuzz.FizzBuzzNumber.FIZZ_BUZZ;
import static com.github.agheorghies.fizzbuzz.FizzBuzzNumber.INTEGER;
import static java.util.Map.entry;
import static org.junit.Assert.assertEquals;


public class FizzBuzzRangeTest {
    FizzBuzzRange fizzBuzzRange = new FizzBuzzRange();

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Test
    public void testMapRange_whenRangeIsIncorrect() {
        assertEquals(fizzBuzzRange.mapRange(3, 2), Collections.emptyList());
    }

    @Test
    public void testMapRange_whenRangeIsCorrect() {
        List<String> expected = Arrays.asList("fizzbuzz", "1", "2", "three", "4", "buzz", "fizz");
        assertEquals(fizzBuzzRange.mapRange(0, 6), expected);
    }

    @Test
    public void testPrintRange_whenRangeIsIncorrect() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(output);

        fizzBuzzRange.printRange(3, 2, printStream);

        assertEquals(output.toString(), "\n");
    }

    @Test
    public void tesPrintRange_whenRangeIsCorrect() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(output);

        fizzBuzzRange.printRange(0, 6, printStream);

        assertEquals(output.toString(), "fizzbuzz 1 2 three 4 buzz fizz\n");
    }

    @Test
    public void testMapRangeByGroups_whenRangeIsIncorrect() {
        assertEquals(fizzBuzzRange.mapRangeByGroups(3, 2), Collections.emptyMap());
    }

    @Test
    public void testMapRangeByGroups_whenRangeIsCorrect() {
        Map<String,Long> expected = Map.ofEntries(
                entry(FIZZ, 4L),
                entry(BUZZ, 3L),
                entry(FIZZ_BUZZ, 1L),
                entry(THREE, 2L),
                entry(INTEGER, 10L)
        );
        assertEquals(fizzBuzzRange.mapRangeByGroups(1, 20), expected);
    }

    @Test
    public void testPrintReport_whenRangeIsIncorrect() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(output);

        fizzBuzzRange.printReport(3, 2, printStream);

        assertEquals(output.toString(), "fizz: 0 buzz: 0 fizzbuzz: 0 three: 0 integer: 0\n");
    }

    @Test
    public void testPrintReport_whenRangeIsCorrect() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(output);

        fizzBuzzRange.printReport(0, 6, printStream);

        assertEquals(output.toString(), "fizz: 1 buzz: 1 fizzbuzz: 1 three: 1 integer: 3\n");
    }

    @Test
    public void testGetReportItem_whenCountIsNull() {
        assertEquals(fizzBuzzRange.getReportItem("group", null), "group: 0");
    }

    @Test
    public void testGetReportItem_whenCountIsNotNull() {
        assertEquals(fizzBuzzRange.getReportItem("group", 2L), "group: 2");
    }
}
