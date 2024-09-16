package com.nhnacademy.shoppingmall.product.service.impl;

import com.nhnacademy.shoppingmall.product.repository.ProductRepository;
import com.nhnacademy.shoppingmall.product.service.ProductService;
import lombok.RequiredArgsConstructor;

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
}
