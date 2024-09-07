package com.nhnacademy.shoppingmall.user.service;

import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.dto.LoginResponse;

public interface UserService {

    User getUser(Integer userId);
    User getUser(String userInputId);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);

    LoginResponse doLogin(String userId, String userPassword);

}
