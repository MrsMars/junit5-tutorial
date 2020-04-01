package com.aoher.util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTestUnit5 {

    @Test
    void testConvertToDoubleOK() {
        String age = "1990";
        Double expectedAge = Double.valueOf(age);
        Double actualAge = StringUtils.convertToDouble(age);

        assertAll("Do many assertions.", () -> {
            assertNotNull(actualAge);
            assertEquals(expectedAge, actualAge);
        });

        // Or Java 8 Lambdas style
        assertAll("Do many assertions.Java 8 Lambdas style", () -> {
            assertNotNull(actualAge, "The actual is NULL");
            assertEquals(expectedAge, actualAge,
                    () -> String.format("The expected is: %s while the actual is:%s", expectedAge, actualAge));
        });
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void testConvertToDoubleWithNullArgument() {
        String age = null;


        Double actual = StringUtils.convertToDouble(age);
        assertNull(actual, "The actual is not null");

        // Java 8 Style
        assertNull(actual, "The actual is not null");
    }

    @Test
    public void testConvertToDoubleThrowException() {
        String age = "N/A";
        assertThrows(NumberFormatException.class, () -> StringUtils.convertToDouble(age));
        assertThrows(NumberFormatException.class, () -> StringUtils.convertToDouble(age));
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void testIsNullOrBlankOK() {
        String input = null;

        assertTrue(StringUtils.isNullOrBlank(input));
        // Java 8 Lambdas Style
        assertTrue(StringUtils.isNullOrBlank(input), "The string is not null or blank");

        input = " ";
        assertTrue(StringUtils.isNullOrBlank(input));

        input = "abc";
        assertFalse(StringUtils.isNullOrBlank(input));

        assertFalse(StringUtils.isNullOrBlank(input));
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void testGetDefaultIfNull() {
        String str = null;
        String defaultStr = "abc";

        String actual = StringUtils.getDefaultIfNull(str, defaultStr);
        assertSame(defaultStr, actual);

        // Java 8 Lambdas Style
        assertSame(defaultStr, actual, "Expected ouput is not same with actual");

        str = "def";
        actual = StringUtils.getDefaultIfNull(str, defaultStr);
        assertNotSame(defaultStr, actual);

        // Java 8 Lambdas Style
        assertNotSame(defaultStr, actual, "Expected ouput is same with actual");

        str = "";
        actual = StringUtils.getDefaultIfNull(str, defaultStr);
        if (actual.equals(defaultStr)) {
            fail("The actual should be empty");

            // Java 8 Lambdas Style
            fail("The actual should be empty");
        }
    }

    @Test
    void testConcatWithRegularInput() {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "!";

        String expected = str1 + str2 + str3;
        String actual = StringUtils.concat(str1, str2, str3);
        assertEquals(expected, actual);
    }

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

    @Disabled
    @Test
    void testConcatWithAllNullInput() {
        String actual = StringUtils.concat();
        assertNull(actual);
    }
}