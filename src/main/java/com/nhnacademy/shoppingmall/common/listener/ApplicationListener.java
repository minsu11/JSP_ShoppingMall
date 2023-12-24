package com.nhnacademy.shoppingmall.common.listener;

import com.nhnacademy.shoppingmall.common.mvc.transaction.DbConnectionThreadLocal;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.repository.impl.UserRepositoryImpl;
import com.nhnacademy.shoppingmall.user.service.UserService;
import com.nhnacademy.shoppingmall.user.service.impl.UserServiceImpl;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class ApplicationListener implements ServletContextListener {
    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.debug("contextInitialized start");
        DbConnectionThreadLocal.initialize();
        if (Objects.isNull(userService.getUser("admin"))) { // admin 존재 시
            User admin = new User("admin", "admin", "1234", "10001010", User.Auth.ROLE_ADMIN, 1000000, LocalDateTime.now(), null);
        }
        if (Objects.isNull(userService.getUser("user"))) { // admin 존재 시
            User user = new User("user", "user", "1234", "10001011", User.Auth.ROLE_USER, 1000000, LocalDateTime.now(), null);
        }

        DbConnectionThreadLocal.reset();

        log.debug("contextInitialized end");
        sce.getServletContext().setAttribute("userService", userService);
    }
}
