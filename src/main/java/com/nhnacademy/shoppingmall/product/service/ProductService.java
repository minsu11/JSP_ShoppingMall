package com.nhnacademy.shoppingmall.product.service;


import com.nhnacademy.shoppingmall.product.domain.Product;
import com.nhnacademy.shoppingmall.product.dto.AdminPageProductInfo;

import java.util.List;

/**
 * packageName    : com.nhnacademy.shoppingmall.product.service
 * fileName       : ProductService
 * author         : parkminsu
 * date           : 2024. 9. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 16.        parkminsu       최초 생성
 */
public interface ProductService  {
    // 관리자에 보일 정보
    List<AdminPageProductInfo> getAdminPageProductInfoList();
    void createProduct(Product product);

}
