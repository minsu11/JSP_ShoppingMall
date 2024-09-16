package com.nhnacademy.shoppingmall.controller.admin;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.annotation.Transaction;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.user.dto.AdminUserInfoResponse;
import com.nhnacademy.shoppingmall.user.repository.impl.UserRepositoryImpl;
import com.nhnacademy.shoppingmall.user.service.UserService;
import com.nhnacademy.shoppingmall.user.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * packageName    : com.nhnacademy.shoppingmall.controller.admin
 * fileName       : AdminController
 * author         : parkminsu
 * date           : 2024. 9. 8.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 8.        parkminsu       최초 생성
 */
@Slf4j
@Transaction
@RequestMapping(method = RequestMapping.Method.GET,value = "/admin/auth/admin/list.do")
public class AdminAuthUserListController implements BaseController {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        UserService userService = (UserService) req.getServletContext().getAttribute("userService");
        List<AdminUserInfoResponse> adminUserInfoResponseList = userService.getAdminUserInfo();
        log.info("list: {}",adminUserInfoResponseList.toString() );
        req.setAttribute("adminUserList", adminUserInfoResponseList);
        return "shop/admin/admin";
    }
}
