package com.nhnacademy.shoppingmall.common.filter;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@WebFilter(filterName = "admingCheckFilter",urlPatterns = "/admin/*")
public class AdminCheckFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        //todo#11 /admin/ 하위 요청은 관리자 권한의 사용자만 접근할 수 있습니다. ROLE_USER가 접근하면 403 Forbidden 에러처리
        String role = String.valueOf(req.getAttribute("login"));
        if(Objects.isNull(role) || role.isEmpty() ) {
            res.sendRedirect("/login.do");
        }
        if (role.equals("ROLE_USER")) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else{
            log.debug("admin filter");
            String path = req.getRequestURI();
            log.debug("path: {}", path);
//            RequestDispatcher rd = req.getRequestDispatcher("/admin/index.jsp");

            chain.doFilter(req, res);
        }

    }
}
