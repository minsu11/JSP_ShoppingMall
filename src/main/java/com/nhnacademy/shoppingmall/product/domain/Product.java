package com.nhnacademy.shoppingmall.product.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * packageName    : com.nhnacademy.shoppingmall.product.domain
 * fileName       : Product
 * author         : parkminsu
 * date           : 2024. 9. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 16.        parkminsu       최초 생성
 */
@Getter
public class Product {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private LocalDateTime createdAt;
}
