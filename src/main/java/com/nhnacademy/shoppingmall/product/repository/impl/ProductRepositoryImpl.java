package com.nhnacademy.shoppingmall.product.repository.impl;

import com.nhnacademy.shoppingmall.common.mvc.transaction.DbConnectionThreadLocal;
import com.nhnacademy.shoppingmall.common.util.DbUtils;
import com.nhnacademy.shoppingmall.product.domain.Product;
import com.nhnacademy.shoppingmall.product.dto.AdminPageProductInfo;
import com.nhnacademy.shoppingmall.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * packageName    : com.nhnacademy.shoppingmall.product.repository.impl
 * fileName       : ProductRepositoryImpl
 * author         : parkminsu
 * date           : 2024. 9. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 16.        parkminsu       최초 생성
 */
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<AdminPageProductInfo> findAllAdminPageProductInfo() {
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "select 'product_number', 'product_name', 'desciption', 'unit_cost', 'product_inventory', 'product_created_at' from products";
        log.debug("sql:{}", sql);
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                List<AdminPageProductInfo> adminPageProductInfoList = new ArrayList<>();
                while (resultSet.next()) {
                    AdminPageProductInfo adminPageProductInfo = AdminPageProductInfo.builder()
                            .number(resultSet.getString("product_number"))
                            .name(resultSet.getString("product_name"))
                            .description(resultSet.getString("desciption"))
                            .cost(resultSet.getInt("unit_cost"))
                            .inventory(resultSet.getInt("product_inventory"))
                            .createdDate(Objects.nonNull(resultSet.getTimestamp("product_created_at")) ? resultSet.getTimestamp("product_created_at").toLocalDateTime() : null)
                            .build();
                    adminPageProductInfoList.add(adminPageProductInfo);
                }
                return adminPageProductInfoList;
            }

        }catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return List.of();
    }

    @Override
    public int saveProduct(Product product) {
        Connection connection = DbConnectionThreadLocal.getConnection();
        int result=0;
        String sql = "insert into('product_number','product_name', 'unit_cost','description', 'product_inventory', 'product_created_at' ) product values(?,?,?,?,?,?,?,?)";
        log.debug("sql:{}", sql);
        try(PreparedStatement psmt= connection.prepareStatement(sql)){
            psmt.setString(1,product.getNumber());
            psmt.setString(2,product.getName());
            psmt.setInt(3,product.getUnitCost());
            psmt.setString(4,product.getDescription());
            psmt.setInt(5,product.getInventory());
            psmt.setTimestamp(6, Timestamp.valueOf(product.getCreatedAt()));
            result = psmt.executeUpdate();

        }catch (SQLException e){
            log.error(e.getMessage(), e);
        }
        return  result;
    }
}
