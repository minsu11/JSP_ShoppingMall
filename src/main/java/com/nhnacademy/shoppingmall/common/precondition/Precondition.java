package com.nhnacademy.shoppingmall.common.precondition;

import com.nhnacademy.shoppingmall.common.exception.NumberNegativeException;

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


    public static void checkEmpty(String value){
        if( value.isEmpty()){
            throw new IllegalArgumentException("Empty String");
        }
    }



    public static void checkNegativeInteger(Integer value){
        if(isNegative(value)){
            throw new NumberNegativeException("negative value");
        }
    }

    private static boolean isNegative(Integer value){
        return value  < 0;
    }


}
