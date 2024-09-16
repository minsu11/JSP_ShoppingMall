package com.nhnacademy.shoppingmall.user.service.impl;

import com.nhnacademy.shoppingmall.common.precondition.Precondition;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.dto.AdminUserInfoResponse;
import com.nhnacademy.shoppingmall.user.dto.LoginResponse;
import com.nhnacademy.shoppingmall.user.exception.UserAlreadyExistsException;
import com.nhnacademy.shoppingmall.user.exception.UserNotFoundException;
import com.nhnacademy.shoppingmall.user.repository.UserRepository;
import com.nhnacademy.shoppingmall.user.service.UserService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Integer userId) {
        Precondition.isCheckNull(userId);
        Precondition.checkNegativeInteger(userId);
        return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));
    }
    @Override
    public User getUser(String userInputId) {
        Precondition.isCheckNull(userInputId);
        Precondition.checkEmpty(userInputId);
        return userRepository.findByInputId(userInputId).orElseThrow(()-> new UserNotFoundException("user not found"));
    }


    @Override
    public void saveUser(User user) {
        if (userRepository.countByUserId(user.getUserId()) > 0) {
            throw new UserAlreadyExistsException("user");
        }
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        if (userRepository.countByUserId(user.getUserId()) > 0) {
            userRepository.update(user);
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));

        userRepository.deleteByUserId(user.getId());

    }

    @Override
    public LoginResponse doLogin(String userInputId, String userPassword) {
        User user = userRepository.findByUserIdAndUserPassword(userInputId, userPassword).orElseThrow(()-> new UserNotFoundException("login fail"));

        userRepository.updateLatestLoginAtByUserId(user.getUserId(), LocalDateTime.now());
        return new LoginResponse(user.getId(), user.getUserAuth().name());
    }

    @Override
    public List<AdminUserInfoResponse> getAdminUserInfo() {
        return userRepository.getAdminList();
    }
}
