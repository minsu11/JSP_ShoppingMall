package com.nhnacademy.shoppingmall.common.precondition;

import java.util.Objects;

public final class Precondition {

    
    private static <T> boolean isNull(T value) {
        return Objects.isNull(value);
    }
}
