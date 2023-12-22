package com.nhnacademy.shoppingmall.common.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "characterEncodingFilter",
        urlPatterns = "/*",
        initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class CharacterEncodingFilter implements Filter {
    String value;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        value = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //todo#8 UTF-8 인코딩, initParams의 encoding parameter value값을 charset 으로 지정합니다.
        servletRequest.setCharacterEncoding(value);
        servletResponse.setCharacterEncoding(value);
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
