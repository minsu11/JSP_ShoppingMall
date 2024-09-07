package com.nhnacademy.shoppingmall.controller.sign;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.annotation.Transaction;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.common.precondition.Precondition;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.repository.impl.UserRepositoryImpl;
import com.nhnacademy.shoppingmall.user.service.UserService;
import com.nhnacademy.shoppingmall.user.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * packageName    : com.nhnacademy.shoppingmall.controller.sign
 * fileName       : SignUpPostController
 * author         : parkminsu
 * date           : 2024. 9. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 7.        parkminsu       최초 생성
 */
@Slf4j
@Transaction
@RequestMapping(method = RequestMapping.Method.POST, value = "/signupAction.do")
public class SignUpPostController  implements BaseController {
    private UserService userService = new UserServiceImpl(new UserRepositoryImpl());
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String inputId = req.getParameter("user_input_id");
        String name = req.getParameter("user_name");
        String password = req.getParameter("user_password");
        String birth = req.getParameter("user_birth");
        log.debug("date: {}", birth);
        Integer point = Integer.parseInt(req.getParameter("user_point"));
        log.debug("parameter 받음");
        log.debug("name: {}",name);
        log.debug("password: {}",password);
        log.debug("point: {}",point);

        try {
            precondition(inputId, name, password, birth, point);
        }catch (Exception e){
            log.error(e.getMessage());
            return "redirect:/signup.do";
        }

        User user = User.builder()
                .userId(inputId)
                .userPassword(password)
                .userName(name)
                .userBirth(birth)
                .userAuth(User.Auth.ROLE_USER)
                .userPoint(point)
                .createdAt(LocalDateTime.now())
                .build();

        userService.saveUser(user);

        return "redirect:/index.do";
    }

    private void precondition(String inputId, String name, String password, String birth, Integer point){
        Precondition.isCheckNull(inputId);
        Precondition.isCheckNull(name);
        Precondition.isCheckNull(password);
        Precondition.isCheckNull(birth);
        Precondition.isCheckNull(point);
        Precondition.checkEmpty(inputId);
        Precondition.checkEmpty(name);
        Precondition.checkEmpty(password);
        Precondition.checkEmpty(birth);
        Precondition.checkNegativeInteger(point);
    }
}
