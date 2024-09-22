package com.nhnacademy.shoppingmall.image.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * packageName    : com.nhnacademy.shoppingmall.image.entity
 * fileName       : Image
 * author         : parkminsu
 * date           : 2024. 9. 19.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 19.        parkminsu       최초 생성
 */
@Getter
@Builder
public class Image {
    private Integer productId;
    private String imagePath;
    private LocalDateTime createAt;


}
