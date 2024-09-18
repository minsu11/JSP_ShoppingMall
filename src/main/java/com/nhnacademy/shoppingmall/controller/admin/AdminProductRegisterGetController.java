package com.nhnacademy.shoppingmall.controller.admin;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * packageName    : com.nhnacademy.shoppingmall.controller.admin
 * fileName       : AdminProductRegistController
 * author         : parkminsu
 * date           : 2024. 9. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 18.        parkminsu       최초 생성
 */
@RequestMapping(method = RequestMapping.Method.GET, value = "/admin/product/register.do")
public class AdminProductRegisterGetController implements BaseController {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {


        return "shop/admin/admin-product-registration-form";
    }
}
