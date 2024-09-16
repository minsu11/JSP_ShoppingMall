package com.nhnacademy.shoppingmall.user.service;

import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.dto.AdminUserInfoResponse;
import com.nhnacademy.shoppingmall.user.dto.LoginResponse;
import com.nhnacademy.shoppingmall.user.dto.UserInfoResponse;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Gets user.
     *
     * @param userId the user id
     * @return the user
     */
    User getUser(Integer userId);

    /**
     * Gets user.
     *
     * @param userInputId the user input id
     * @return the user
     */
    User getUser(String userInputId);

    /**
     * Save user.
     *
     * @param user the user
     */
    void saveUser(User user);

    /**
     * Update user.
     *
     * @param user the user
     */
    void updateUser(User user);

    /**
     * Delete user.
     *
     * @param userId the user id
     */
    void deleteUser(Integer userId);

    /**
     * Do login login response.
     *
     * @param userId       the user id
     * @param userPassword the user password
     * @return the login response
     */
    LoginResponse doLogin(String userId, String userPassword);


    /**
     * 관리자 권한 유저 리스트 반환<br>
     * value가 없을 땐 Empty List
     *
     *
     * @return 관리자 권한을 가진 유저 리스트 반환
     */
    List<AdminUserInfoResponse> getAdminUserInfo();

    List<UserInfoResponse> getUserInfoList();

}
