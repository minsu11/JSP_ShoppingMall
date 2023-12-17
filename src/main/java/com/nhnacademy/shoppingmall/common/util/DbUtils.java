package com.nhnacademy.shoppingmall.common.util;


import java.sql.SQLException;
import java.time.Duration;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class DbUtils {
    public DbUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static final DataSource DATASOURCE;

    static {
        BasicDataSource basicDataSource = new BasicDataSource();

        try {
            basicDataSource.setDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        basicDataSource.setUrl("jdbc:mysql://localhost:3306/ShoppingMall");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("1234");

        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxTotal(5);
        basicDataSource.setMaxIdle(5);
        basicDataSource.setMinIdle(5);
        basicDataSource.setValidationQuery("select 1");
        basicDataSource.setMaxWait(Duration.ofSeconds(2));

        DATASOURCE = basicDataSource;

    }

    public static DataSource getDataSource() {
        return DATASOURCE;
    }

}
