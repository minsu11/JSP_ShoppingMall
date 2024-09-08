package com.nhnacademy.shoppingmall.controller.mypage;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.annotation.Transaction;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * packageName    : com.nhnacademy.shoppingmall.controller.mypage
 * fileName       : MyPageOrderLisstController
 * author         : parkminsu
 * date           : 2024. 9. 8.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 8.        parkminsu       최초 생성
 */
@Transaction
@RequestMapping(method = RequestMapping.Method.GET, value = "/mypage/order/list")
public class MyPageOrderLisstController implements BaseController {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "";
    }
}
