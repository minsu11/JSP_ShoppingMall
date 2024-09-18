package com.nhnacademy.shoppingmall.controller.admin;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.annotation.Transaction;

/**
 * packageName    : com.nhnacademy.shoppingmall.controller.admin
 * fileName       : AdminProductRegisterPostController
 * author         : parkminsu
 * date           : 2024. 9. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 18.        parkminsu       최초 생성
 */
@Transaction
@RequestMapping(method = RequestMapping.Method.POST,value = "/admin/product/register.do")
public class AdminProductRegisterPostController {
}
