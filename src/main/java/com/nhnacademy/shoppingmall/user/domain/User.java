package com.nhnacademy.shoppingmall.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class User {
    public enum Auth{
        ROLE_ADMIN,ROLE_USER
    }

    private Integer id;
    private String userId;
    private String userName;
    private String userPassword;
    private String userBirth;
    private Auth userAuth;
    private int userPoint;
    private LocalDateTime createdAt;
    private LocalDateTime latestLoginAt;

    public User(Integer id, String userId, String userName, String userPassword, String userBirth, Auth userAuth, int userPoint, LocalDateTime createdAt, LocalDateTime latestLoginAt) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userBirth = userBirth;
        this.userAuth = userAuth;
        this.userPoint = userPoint;
        this.createdAt = createdAt;
        this.latestLoginAt = latestLoginAt;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public void setUserAuth(Auth userAuth) {
        this.userAuth = userAuth;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userPoint == user.userPoint &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userPassword, user.userPassword) &&
                Objects.equals(userBirth, user.userBirth) &&
                userAuth == user.userAuth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userPassword, userBirth, userAuth, userPoint);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userAuth=" + userAuth +
                ", userPoint=" + userPoint +
                ", createdAt=" + createdAt +
                ", latestLoginAt=" + latestLoginAt +
                '}';
    }
}

