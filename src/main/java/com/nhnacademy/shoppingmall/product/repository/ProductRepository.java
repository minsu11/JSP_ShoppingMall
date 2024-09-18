package com.nhnacademy.shoppingmall.product.repository;

import com.nhnacademy.shoppingmall.product.domain.Product;
import com.nhnacademy.shoppingmall.product.dto.AdminPageProductInfo;

import java.util.List;

/**
 * packageName    : com.nhnacademy.shoppingmall.product.repository
 * fileName       : ProductRepository
 * author         : parkminsu
 * date           : 2024. 9. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 16.        parkminsu       최초 생성
 */
public interface ProductRepository {
    List<AdminPageProductInfo> findAllAdminPageProductInfo();

    int saveProduct(Product product);

}
