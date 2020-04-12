package com.github.agheorghies.fizzbuzz;

import org.junit.Test;

import static com.github.agheorghies.fizzbuzz.FizzBuzzNumber.THREE;
import static com.github.agheorghies.fizzbuzz.FizzBuzzNumber.BUZZ;
import static com.github.agheorghies.fizzbuzz.FizzBuzzNumber.FIZZ;
import static com.github.agheorghies.fizzbuzz.FizzBuzzNumber.FIZZ_BUZZ;
import static com.github.agheorghies.fizzbuzz.FizzBuzzNumber.INTEGER;
import static org.junit.Assert.assertEquals;

public class FizzBuzzNumberTest {

    @Test
    public void testMapNumber_whenContains3_expectThree() {
        assertEquals(FizzBuzzNumber.mapNumber(-3), THREE);
        assertEquals(FizzBuzzNumber.mapNumber(13), THREE);
        assertEquals(FizzBuzzNumber.mapNumber(131), THREE);
    }

    @Test
    public void testMapNumber_whenMultipleOf15_expectFizzbuzz() {
        assertEquals(FizzBuzzNumber.mapNumber(-15), FIZZ_BUZZ);
        assertEquals(FizzBuzzNumber.mapNumber(0), FIZZ_BUZZ);
        assertEquals(FizzBuzzNumber.mapNumber(15), FIZZ_BUZZ);
    }

    @Test
    public void testMapNumber_whenMultipleOf3_expectFizz() {
        assertEquals(FizzBuzzNumber.mapNumber(-6), FIZZ);
        assertEquals(FizzBuzzNumber.mapNumber(9), FIZZ);
    }

    @Test
    public void testMapNumber_whenMultipleOf5_expectBuzz() {
        assertEquals(FizzBuzzNumber.mapNumber(-5), BUZZ);
        assertEquals(FizzBuzzNumber.mapNumber(5), BUZZ);
        assertEquals(FizzBuzzNumber.mapNumber(10), BUZZ);
    }

    @Test
    public void testMapNumber_expectValue() {
        assertEquals(FizzBuzzNumber.mapNumber(2), "2");
    }

    @Test
    public void testMapGroup_whenContains3_expectThree() {
        assertEquals(FizzBuzzNumber.mapGroup(13), THREE);
    }

    @Test
    public void testMapGroup_whenMultipleOf15_expectFizzbuzz() {
        assertEquals(FizzBuzzNumber.mapGroup(15), FIZZ_BUZZ);
    }

    @Test
    public void testMapGroup_whenMultipleOf3_expectFizz() {
        assertEquals(FizzBuzzNumber.mapGroup(6), FIZZ);
    }

    @Test
    public void testMapGroup_whenMultipleOf5_expectBuzz() {
        assertEquals(FizzBuzzNumber.mapGroup(10), BUZZ);
    }

    @Test
    public void testMapGroup_expectInteger() {
        assertEquals(FizzBuzzNumber.mapGroup(2), INTEGER);
    }
}
