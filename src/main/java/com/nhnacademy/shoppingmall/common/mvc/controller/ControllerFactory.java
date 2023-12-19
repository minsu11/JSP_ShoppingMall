package com.nhnacademy.shoppingmall.common.mvc.controller;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.exception.ControllerNotFoundException;
import com.nhnacademy.shoppingmall.common.precondition.Precondition;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ControllerFactory {
    public static final String CONTEXT_CONTROLLER_FACTORY_NAME = "CONTEXT_CONTROLLER_FACTORY";
    private final ConcurrentMap<String, Object> beanMap = new ConcurrentHashMap<>();

    public void initialize(Set<Class<?>> c, ServletContext ctx) {

        if (Objects.isNull(c)) {
            log.info("Controller not found");
            return;
        }

        try {
            for (Class<?> clazz : c) {
                RequestMapping.Method method = clazz.getAnnotation(RequestMapping.class).method();
                String[] values = clazz.getAnnotation(RequestMapping.class).value();
                Object o = clazz.getDeclaredConstructor().newInstance();
                for (String value : values) {
                    beanMap.put(method + "-" + value, o);
                }
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        ctx.setAttribute(CONTEXT_CONTROLLER_FACTORY_NAME, this);

    }

    private Object getBean(String key) {
        return beanMap.get(key);
    }

    public Object getController(HttpServletRequest request) {
        Precondition.isCheckNull(request);
        return getBean(getKey(request.getMethod(), request.getServletPath()));
    }

    public Object getController(String method, String path) {
        Precondition.isCheckNull(method);
        Precondition.isCheckNull(path);
        Object controller = getBean(getKey(method, path));
        if (Objects.isNull(controller)) {
            throw new ControllerNotFoundException("controller Not Found");
        }
        return controller;
    }

    private String getKey(String method, String path) {
        return method + "-" + path;
    }
}
