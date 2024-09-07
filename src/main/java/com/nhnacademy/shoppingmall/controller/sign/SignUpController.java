package com.nhnacademy.shoppingmall.controller.sign;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.user.dto.LoginResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * packageName    : com.nhnacademy.shoppingmall.controller.sign
 * fileName       : SignUpController
 * author         : parkminsu
 * date           : 2024. 9. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 7.        parkminsu       최초 생성
 */
@RequestMapping(method = RequestMapping.Method.GET, value = "/signup.do")
public class SignUpController implements BaseController {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        if(session != null) {
            LoginResponse loginResponse =(LoginResponse) session.getAttribute("loginResponse");
            if(loginResponse != null) {
                return "redirect:/index.do";
            }
        }
        return "shop/sign/signup";
    }
}
