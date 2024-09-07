package com.nhnacademy.shoppingmall.common.exception;

/**
 * packageName    : com.nhnacademy.shoppingmall.common.exception
 * fileName       : NumberNegativeException
 * author         : parkminsu
 * date           : 2024. 9. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 7.        parkminsu       최초 생성
 */
public class NumberNegativeException extends RuntimeException {
    public NumberNegativeException() {
    }

    public NumberNegativeException(String message) {
        super(message);
    }
}
