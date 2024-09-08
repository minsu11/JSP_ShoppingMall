package com.nhnacademy.shoppingmall.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * packageName    : com.nhnacademy.shoppingmall.order.domain
 * fileName       : Order
 * author         : parkminsu
 * date           : 2024. 9. 8.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 8.        parkminsu       최초 생성
 */
@Getter
@NoArgsConstructor
public class Order {
    private Integer id;
    private LocalDateTime orderDate;
    private String address;
    private LocalDateTime shipDate;

}
