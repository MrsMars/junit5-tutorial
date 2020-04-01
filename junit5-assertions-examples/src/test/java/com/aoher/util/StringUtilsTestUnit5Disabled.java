package com.aoher.util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StringUtilsTestUnit5Disabled {

    @Test
    void testConcatWithRegularInput() {
        String st1 = "Hello";
        String st2 = "World";
        String st3 = "!";

        String expect = st1 + st2 + st3;
        String actual = StringUtils.concat(st1, st2, st3);

        assertEquals(expect, actual);
    }

    @Disabled
    @Test
    @SuppressWarnings("ConstantConditions")
    void testConcatWithNullInput() {
        String st1 = "Hello";
        String st2 = "World";
        String st3 = null;

        String expect = st1 + st2;
        String actual = StringUtils.concat(st1, st2, st3);

        assertEquals(expect, actual);
    }

    @Test
    public void testConcatWithAllNullInput() {
        String actual = StringUtils.concat();
        assertNull(actual);
    }
}
