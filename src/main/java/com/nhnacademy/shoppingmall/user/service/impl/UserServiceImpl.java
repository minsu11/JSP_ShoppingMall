package com.nhnacademy.shoppingmall.user.service.impl;

import com.nhnacademy.shoppingmall.common.precondition.Precondition;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.exception.UserAlreadyExistsException;
import com.nhnacademy.shoppingmall.user.exception.UserNotFoundException;
import com.nhnacademy.shoppingmall.user.repository.UserRepository;
import com.nhnacademy.shoppingmall.user.service.UserService;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String userId) {
        Precondition.isCheckNull(userId);
        User user = userRepository.findById(userId).orElse(null);
        if (Objects.isNull(user)) {
            log.debug("user:{}", user);
            return null;
        }
        return user;
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
    public void deleteUser(String userId) {
        if (userRepository.countByUserId(userId) > 0) {
            userRepository.deleteByUserId(userId);
        }

    }

    @Override
    public User doLogin(String userId, String userPassword) {
        User user = userRepository.findByUserIdAndUserPassword(userId, userPassword).orElse(null);
        if (Objects.nonNull(user)) {
            userRepository.updateLatestLoginAtByUserId(user.getUserId(), LocalDateTime.now());
            return user;
        }
        throw new UserNotFoundException("login fail");
    }

}
