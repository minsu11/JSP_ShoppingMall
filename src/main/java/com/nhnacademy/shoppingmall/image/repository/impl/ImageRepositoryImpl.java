package com.nhnacademy.shoppingmall.image.repository.impl;

import com.nhnacademy.shoppingmall.common.mvc.transaction.DbConnectionThreadLocal;
import com.nhnacademy.shoppingmall.image.entity.Image;
import com.nhnacademy.shoppingmall.image.repository.ImageRepository;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * packageName    : com.nhnacademy.shoppingmall.file.repository.impl
 * fileName       : FileRepositoryImpl
 * author         : parkminsu
 * date           : 2024. 9. 19.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 19.        parkminsu       최초 생성
 */
@Slf4j
public class ImageRepositoryImpl implements ImageRepository {

    @Override
    public Integer saveImage(Image image) {
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "insert into Image(product_id, image_path, image_created_at) values(?,?,?)";
        log.debug("sql:{}", sql);
        try(PreparedStatement psmt = connection.prepareStatement(sql)){
            psmt.setInt(1, image.getProductId());
            psmt.setString(2, image.getImagePath());
            psmt.setTimestamp(3, Timestamp.valueOf(image.getCreateAt()));
            return psmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
