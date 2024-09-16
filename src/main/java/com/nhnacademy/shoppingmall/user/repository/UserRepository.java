package com.nhnacademy.shoppingmall.user.repository;

import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.dto.AdminUserInfoResponse;
import com.nhnacademy.shoppingmall.user.dto.UserInfoResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<UserInfoResponse> getUserList();
    List<AdminUserInfoResponse> getAdminList();
    Optional<User> findByUserIdAndUserPassword(String userId, String userPassword);
    Optional<User> findById(Integer id);
    Optional<User> findByInputId(String inputId);
    int save(User user);
    int deleteByUserId(Integer userId);
    int update(User user);
    int updateLatestLoginAtByUserId(String userId, LocalDateTime latestLoginAt);
    int countByUserId(String userId);
}
