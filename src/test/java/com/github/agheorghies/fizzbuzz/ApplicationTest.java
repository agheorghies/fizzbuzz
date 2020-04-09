package com.github.agheorghies.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {

    @Test
    public void testParseIntArgument_whenValid() {
        assertEquals(Application.parseIntArgument("1", "name"), 1);
    }

    @Test(expected = RuntimeException.class)
    public void testParseIntArgument_whenInvalid() {
        assertEquals(Application.parseIntArgument("abc", "name"), 1);
    }
}
