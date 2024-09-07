package com.nhnacademy.shoppingmall.controller.auth;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(method = RequestMapping.Method.GET, value = "/logoutAction.do")
public class LogoutController implements BaseController {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession httpSession = req.getSession(false);
        if(Objects.nonNull(httpSession)) {
            if (Objects.nonNull(httpSession.getAttribute("loginResponse"))) {
                httpSession.removeAttribute("loginResponse");
            }
        }
        return "redirect:/index.do";
    }
}
