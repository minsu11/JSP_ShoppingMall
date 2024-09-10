package com.nhnacademy.shoppingmall.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * packageName    : com.nhnacademy.shoppingmall.user.dto
 * fileName       : UserInfoResponse
 * author         : parkminsu
 * date           : 2024. 9. 8.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 8.        parkminsu       최초 생성
 */
@Getter
@Builder
public class UserInfoResponse {
    private String id;
    private String name;
    private String birth;
    private String auth;
    private Integer point;
    private LocalDateTime createdAt;
    private LocalDateTime lastedLoginAt;
}
