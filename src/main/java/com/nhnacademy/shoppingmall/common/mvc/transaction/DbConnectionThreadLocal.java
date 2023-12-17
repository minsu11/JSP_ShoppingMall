package com.nhnacademy.shoppingmall.common.mvc.transaction;

import com.nhnacademy.shoppingmall.common.util.DbUtils;
import java.sql.Connection;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DbConnectionThreadLocal {
    private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Boolean> sqlErrorThreadLocal = ThreadLocal.withInitial(() -> false);

    public static void initialize() {
        try {
            Connection connection = DbUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connectionThreadLocal.set(connection);
        } catch (SQLException e) {
            log.error("initialize error:{}", connectionThreadLocal);
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connectionThreadLocal.get();
    }

    public static void setSqlError(boolean sqlError) {
        sqlErrorThreadLocal.set(sqlError);
    }

    public static boolean getSqlError() {
        return sqlErrorThreadLocal.get();
    }

    public static void reset() {
        try {
            Connection connection = connectionThreadLocal.get();
            if (getSqlError()) {
                connection.rollback();
            } else {
                connection.commit();
            }
            connection.close();
            connectionThreadLocal.set(connection);
        } catch (SQLException e) {
            log.error("reset error");
            throw new RuntimeException(e);

        }
    }
}
