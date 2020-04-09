package com.github.agheorghies.fizzbuzz;

import org.junit.Test;

import static com.github.agheorghies.fizzbuzz.FizzBuzz.BUZZ;
import static com.github.agheorghies.fizzbuzz.FizzBuzz.FIZZ;
import static com.github.agheorghies.fizzbuzz.FizzBuzz.FIZZ_BUZZ;
import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void testMapNumber_whenMultipleOf15_expectFizzbuzz() {
        assertEquals(FizzBuzz.mapNumber(-15), FIZZ_BUZZ);
        assertEquals(FizzBuzz.mapNumber(0), FIZZ_BUZZ);
        assertEquals(FizzBuzz.mapNumber(15), FIZZ_BUZZ);
    }

    @Test
    public void testMapNumber_whenMultipleOf3_expectFizz() {
        assertEquals(FizzBuzz.mapNumber(-3), FIZZ);
        assertEquals(FizzBuzz.mapNumber(3), FIZZ);
        assertEquals(FizzBuzz.mapNumber(9), FIZZ);
    }

    @Test
    public void testMapNumber_whenMultipleOf5_expectBuzz() {
        assertEquals(FizzBuzz.mapNumber(-5), BUZZ);
        assertEquals(FizzBuzz.mapNumber(5), BUZZ);
        assertEquals(FizzBuzz.mapNumber(10), BUZZ);
    }

    @Test
    public void testMapNumber_expectValue() {
        assertEquals(FizzBuzz.mapNumber(2), "2");
    }

    @Test
    public void testMapRange_whenRangeIsIncorrect() {
        assertEquals(FizzBuzz.mapRange(3, 2), "");
    }

    @Test
    public void testMapRange_whenRangeIsCorrect() {
        assertEquals(FizzBuzz.mapRange(0, 6), "fizzbuzz 1 2 fizz 4 buzz fizz");
    }
}
