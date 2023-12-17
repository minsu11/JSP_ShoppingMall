package com.nhnacademy.shoppingmall.common.precondition;

import java.util.Objects;

public final class Precondition {

    public static <T> void isCheckNull(T value) {
        if (isNull(value)) {
            throw new NullPointerException();
        }
    }

    public static <T> void isCheckNull(T value, Object format) {
        if (isNull(value)) {
            throw new NullPointerException(String.valueOf(format));
        }
    }

    private static <T> boolean isNull(T value) {
        return Objects.isNull(value);
    }
}
