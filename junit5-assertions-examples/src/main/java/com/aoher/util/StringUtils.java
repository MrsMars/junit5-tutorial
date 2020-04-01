package com.aoher.util;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public final class StringUtils {

    public static Double convertToDouble(String str) {
        return str == null ? null : Double.valueOf(str);
    }

    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String getDefaultIfNull(final String str, final String defaultStr) {
        return str == null ? defaultStr : str;
    }

    public static String concat(String... strings) {
        return strings != null && strings.length > 0 ?
                Arrays.stream(strings).filter(Objects::nonNull).collect(Collectors.joining()) : null;
    }

    private StringUtils() {
    }
}
