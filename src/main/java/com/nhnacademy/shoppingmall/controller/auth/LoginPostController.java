package com.nhnacademy.shoppingmall.controller.auth;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.annotation.Transaction;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.dto.LoginResponse;
import com.nhnacademy.shoppingmall.user.repository.impl.UserRepositoryImpl;
import com.nhnacademy.shoppingmall.user.service.UserService;
import com.nhnacademy.shoppingmall.user.service.impl.UserServiceImpl;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transaction
@RequestMapping(method = RequestMapping.Method.POST, value = "/loginAction.do")
public class LoginPostController implements BaseController {

    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("user_id");
        String userPassword = req.getParameter("user_password");
        LoginResponse loginResponse = userService.doLogin(userId, userPassword);
        log.debug("user:{}", loginResponse);
        if (Objects.nonNull(loginResponse)) { // user 존재 시
            HttpSession loginSession = req.getSession(true);
            loginSession.setMaxInactiveInterval(3600);
            loginSession.setAttribute("loginResponse", loginResponse);
            req.getServletContext().setAttribute("loginSession", loginSession);
            log.debug("login session:{}", loginSession);
            return "redirect:/index.do";
        }
        return "redirect:/login.do";
    }
}
