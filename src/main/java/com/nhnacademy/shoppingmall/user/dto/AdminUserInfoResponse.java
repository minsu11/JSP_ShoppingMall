package com.nhnacademy.shoppingmall.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.nhnacademy.shoppingmall.user.dto
 * fileName       : AdminUserInfoResponse
 * author         : parkminsu
 * date           : 2024. 9. 11.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 11.        parkminsu       최초 생성
 */
@Getter
@Builder
public class AdminUserInfoResponse {
    private String id;
    private String name;
    private String birth;
    private String auth;
}
