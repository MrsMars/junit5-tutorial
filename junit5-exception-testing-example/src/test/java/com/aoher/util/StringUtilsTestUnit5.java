package com.aoher.util;

import org.junit.jupiter.api.Test;

import static com.aoher.util.Constants.EMPTY_STRING_EXCEPTION;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ConstantConditions")
class StringUtilsTestUnit5 {

    @Test
    void convertToIntNullParameterAssertThrows() {
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> StringUtils.convertToInt(str));
    }

    @Test
    void convertToIntNullParameterExpectThrows() {
        String str = null;
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> StringUtils.convertToInt(str));
        assertEquals(EMPTY_STRING_EXCEPTION, exception.getMessage());
    }

    @Test
    void convertToIntNullParameterTryCatchIdiom() {
        String str = null;
        try {
            StringUtils.convertToInt(str);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(EMPTY_STRING_EXCEPTION, e.getMessage());
        }
    }
}