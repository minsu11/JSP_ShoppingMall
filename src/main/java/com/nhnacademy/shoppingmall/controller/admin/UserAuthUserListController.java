package com.nhnacademy.shoppingmall.controller.admin;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.annotation.Transaction;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.dto.UserInfoResponse;
import com.nhnacademy.shoppingmall.user.repository.impl.UserRepositoryImpl;
import com.nhnacademy.shoppingmall.user.service.UserService;
import com.nhnacademy.shoppingmall.user.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * packageName    : com.nhnacademy.shoppingmall.controller.admin
 * fileName       : UserAuthUserListController
 * author         : parkminsu
 * date           : 2024. 9. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 16.        parkminsu       최초 생성
 */
@Transaction
@RequestMapping(method = RequestMapping.Method.GET, value = "/admin/auth/user/list.do")
public class UserAuthUserListController implements BaseController {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        UserService userService = (UserService) req.getServletContext().getAttribute("userService");

        List<UserInfoResponse> userInfoResponseList = userService.getUserInfoList();
        req.setAttribute("userList", userInfoResponseList);
        return "shop/admin/admin-user-list";
    }
}
