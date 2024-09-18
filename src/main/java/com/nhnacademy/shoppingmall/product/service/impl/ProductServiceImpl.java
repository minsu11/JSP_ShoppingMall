package com.nhnacademy.shoppingmall.product.service.impl;

import com.nhnacademy.shoppingmall.product.domain.Product;
import com.nhnacademy.shoppingmall.product.dto.AdminPageProductInfo;
import com.nhnacademy.shoppingmall.product.repository.ProductRepository;
import com.nhnacademy.shoppingmall.product.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

/**
 * packageName    : com.nhnacademy.shoppingmall.product.service.impl
 * fileName       : ProductServiceImpl
 * author         : parkminsu
 * date           : 2024. 9. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 16.        parkminsu       최초 생성
 */
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<AdminPageProductInfo> getAdminPageProductInfoList() {
        return productRepository.findAllAdminPageProductInfo();
    }

    @Override
    public void createProduct(Product product) {
        if(Objects.isNull(product)){
            throw new NullPointerException("product is null");
        }
        int result = productRepository.saveProduct(product);

        if(result <= 0){
            throw new IllegalArgumentException("product not saved");
        }
    }


}
