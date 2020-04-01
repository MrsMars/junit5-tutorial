package com.aoher.util;

import static com.aoher.util.Constants.EMPTY_STRING_EXCEPTION;

public class StringUtils {

    public static Integer convertToInt(String str) {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException(EMPTY_STRING_EXCEPTION);
        }
        return Integer.valueOf(str);
    }

    private StringUtils() {
    }
}
