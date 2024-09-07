package com.nhnacademy.shoppingmall.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * packageName    : com.nhnacademy.shoppingmall.user.dto
 * fileName       : LoginResponse
 * author         : parkminsu
 * date           : 2024. 9. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 7.        parkminsu       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse implements Serializable {
    private Integer id;
    private String auth;

}
