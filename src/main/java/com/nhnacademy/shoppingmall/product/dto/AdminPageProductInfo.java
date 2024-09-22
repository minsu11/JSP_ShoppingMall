package com.nhnacademy.shoppingmall.product.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * packageName    : com.nhnacademy.shoppingmall.product.dto
 * fileName       : AdminPageProductInfo
 * author         : parkminsu
 * date           : 2024. 9. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 16.        parkminsu       최초 생성
 */
@Getter
@Builder
public class AdminPageProductInfo {
    private String number;
    private String name;
    private String description;
    private Integer cost;
    private Integer inventory;
    private LocalDateTime createdDate;
    private String img;

}
