package com.nhnacademy.shoppingmall.user.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Integer userId){
        super(String.format("user not found:"+userId));
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
