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

        try{
           userService.getUser("admin");
        }catch (Exception e){
            User admin = new User(1,"admin", "admin", "1234", "10001010", User.Auth.ROLE_ADMIN, 1000000, LocalDateTime.now(), null);
            log.debug("admin:{}", admin);
            userService.saveUser(admin);
        }

        try{
            userService.getUser("user");
        }catch (Exception e){
            User user = new User(2,"user", "user", "1234", "10001011", User.Auth.ROLE_USER, 1000000, LocalDateTime.now(), null);
            log.debug("user:{}", user);
            userService.saveUser(user);
        }


        DbConnectionThreadLocal.reset();

        log.debug("contextInitialized end");
        sce.getServletContext().setAttribute("userService", userService);
    }
}
