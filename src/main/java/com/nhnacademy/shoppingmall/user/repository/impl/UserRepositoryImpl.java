package com.nhnacademy.shoppingmall.user.repository.impl;

import com.nhnacademy.shoppingmall.common.mvc.transaction.DbConnectionThreadLocal;
import com.nhnacademy.shoppingmall.common.precondition.Precondition;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.repository.UserRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> findByUserIdAndUserPassword(String userId, String userPassword) {
        Precondition.isCheckNull(userId, "userId Null");
        Precondition.isCheckNull(userPassword, "userPassword Null");
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "select user_id, user_name, user_password, user_birth, user_auth, user_point, created_at, latest_login_at from users where user_id=? and user_password =?";

        log.debug("sql:{}", sql);

        try (PreparedStatement psmt = connection.prepareStatement(sql);
        ) {
            psmt.setString(1, userId);
            psmt.setString(2, userPassword);
            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User(
                            rs.getString("user_id"),
                            rs.getString("user_name"),
                            rs.getString("user_password"),
                            rs.getString("user_birth"),
                            User.Auth.valueOf(rs.getString("user_auth")),
                            rs.getInt("user_point"),
                            Objects.nonNull(rs.getTimestamp("created_at")) ? rs.getTimestamp("created_at").toLocalDateTime() : null,
                            Objects.nonNull(rs.getTimestamp("latest_login_at")) ? rs.getTimestamp("latest_login_at").toLocalDateTime() : null
                    );
                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> findById(String userId) {
        Precondition.isCheckNull(userId, "userId Null");
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "select user_id, user_name, user_password, user_birth, user_auth, user_point, created_at, latest_login_at from users where user_id=?";

        log.debug("sql:{}", sql);

        try (PreparedStatement psmt = connection.prepareStatement(sql);
        ) {
            psmt.setString(1, userId);
            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User(
                            rs.getString("user_id"),
                            rs.getString("user_name"),
                            rs.getString("user_password"),
                            rs.getString("user_birth"),
                            User.Auth.valueOf(rs.getString("user_auth")),
                            rs.getInt("user_point"),
                            Objects.nonNull(rs.getTimestamp("created_at")) ? rs.getTimestamp("created_at").toLocalDateTime() : null,
                            Objects.nonNull(rs.getTimestamp("latest_login_at")) ? rs.getTimestamp("latest_login_at").toLocalDateTime() : null
                    );
                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public int save(User user) {
        Precondition.isCheckNull(user, "user Null");
        String sql = "insert into  users (user_Id, user_name, user_password, user_birth, user_auth, user_point,created_at)values(?,?,?,?,?,?,?)";
        Connection connection = DbConnectionThreadLocal.getConnection();
        try (PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.setString(1, user.getUserId());
            psmt.setString(2, user.getUserName());
            psmt.setString(3, user.getUserPassword());
            psmt.setString(4, user.getUserBirth());
            psmt.setString(5, String.valueOf(user.getUserAuth()));
            psmt.setInt(6, user.getUserPoint());
            psmt.setString(7, String.valueOf(user.getCreatedAt()));
            return psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteByUserId(String userId) {
        Precondition.isCheckNull(userId, "userId Null");
        String sql = "delete from users where user_id = ?";
        Connection connection = DbConnectionThreadLocal.getConnection();

        try (PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.setString(1, userId);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(User user) {
        Precondition.isCheckNull(user, "user Null");
        String sql = "update users set user_id = ?, user_name = ?, user_password = ?, user_birth =?,user_auth = ?, user_point=?, created_at =? where user_id =?";
        log.debug("sql:{}", sql);

        Connection connection = DbConnectionThreadLocal.getConnection();
        try (PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.setString(1, user.getUserId());
            psmt.setString(2, user.getUserName());
            psmt.setString(3, user.getUserPassword());
            psmt.setString(4, user.getUserBirth());
            psmt.setString(5, String.valueOf(user.getUserAuth()));
            psmt.setInt(6, user.getUserPoint());
            psmt.setString(7, String.valueOf(user.getCreatedAt()));
            psmt.setString(8, user.getUserId());
            return psmt.executeUpdate();
        } catch (SQLException e) {
            log.error("update error");
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateLatestLoginAtByUserId(String userId, LocalDateTime latestLoginAt) {
        Precondition.isCheckNull(userId);
        Precondition.isCheckNull(latestLoginAt);
        String sql = "update users set latest_login_at = ? where user_id = ?";
        Connection connection = DbConnectionThreadLocal.getConnection();
        try (PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.setString(1, String.valueOf(latestLoginAt));
            psmt.setString(2, userId);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            log.error("error");
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countByUserId(String userId) {
        Precondition.isCheckNull(userId, "userId null");

        String sql = "select count(*) as count from users where user_id = ?";
        Connection connection = DbConnectionThreadLocal.getConnection();
        try (PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.setString(1, userId);

            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("count");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

}
