package com.nhnacademy.shoppingmall.common.mvc.controller;

import com.nhnacademy.shoppingmall.common.mvc.annotation.Transaction;
import com.nhnacademy.shoppingmall.common.mvc.transaction.DbConnectionThreadLocal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * packageName    : com.nhnacademy.shoppingmall.common.mvc.controller
 * fileName       : ControllerProxy
 * author         : parkminsu
 * date           : 2024. 9. 7.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 7.        parkminsu       최초 생성
 */
public class ControllerProxy {
    private BaseController baseController;

    public ControllerProxy(BaseController baseController) {
        this.baseController = baseController;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Transaction t = baseController.getClass().getAnnotation(Transaction.class);
        boolean isTransaction = Objects.nonNull(t);

        if(isTransaction){ // annotaion 달린 contorller에만 connection 할당
            DbConnectionThreadLocal.initialize();
        }

        String viewName;
        try {
            viewName = baseController.execute(request, response);
        }catch (Exception e){
            if(isTransaction){
                DbConnectionThreadLocal.setSqlError(true);
            }
            throw e;
        }finally {
            if(isTransaction){
                DbConnectionThreadLocal.reset();
            }
        }

        return viewName;
    }
}
