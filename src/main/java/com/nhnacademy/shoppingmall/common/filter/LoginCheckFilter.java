package com.nhnacademy.shoppingmall.common.filter;

import com.nhnacademy.shoppingmall.common.mvc.view.ViewResolver;
import com.nhnacademy.shoppingmall.user.domain.User;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nhnacademy.shoppingmall.user.dto.LoginResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/mypage/*")
public class LoginCheckFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession httpSession = req.getSession(false);
        if(Objects.isNull(httpSession)) {
            res.sendRedirect( "/login.do");
        }
        LoginResponse user = (LoginResponse) httpSession.getAttribute("loginResponse");
        if (Objects.nonNull(user)) {
            log.debug("LoginCheckFilter dofilter");
            chain.doFilter(req, res);
        } else {
            log.debug("LoginCheckFilter sendRedirect");
            res.sendRedirect("/login.do");
        }
    }
}