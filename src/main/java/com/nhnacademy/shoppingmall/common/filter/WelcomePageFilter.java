package com.nhnacademy.shoppingmall.common.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(filterName = "welcomePageFilter", value = "/*", initParams = {@WebInitParam(name = "welcome", value = "/")})
public class WelcomePageFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getServletPath().equals(getFilterConfig().getInitParameter("welcome"))) {
            res.sendRedirect("/index.do");
        } else {
            chain.doFilter(req, res);
        }
    }
}
