package com.nhnacademy.shoppingmall.common.mvc.view;

import com.nhnacademy.shoppingmall.common.precondition.Precondition;

public class ViewResolver {

    public static final String DEFAULT_PREFIX = "/WEB-INF/views/";
    public static final String DEFAULT_POSTFIX = ".jsp";
    public static final String REDIRECT_PREFIX = "redirect:";
    public static final String DEFAULT_SHOP_LAYOUT = "/WEB-INF/views/layout/shop.jsp";
    public static final String DEFAULT_ADMIN_LAYOUT = "/WEB-INF/views/layout/admin.jsp";
    public static final String LAYOUT_CONTENT_HOLDER = "layout_content_holder";
    public static final String LAYOUT_MYPAGE = "layout_mypage";

    private final String prefix;
    private final String postfix;

    public ViewResolver() {
        this(DEFAULT_PREFIX, DEFAULT_POSTFIX);
    }

    public ViewResolver(String prefix, String postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    public String getPath(String viewName) {
        Precondition.isCheckNull(viewName);
        if (viewName.startsWith("/")) {
            viewName = viewName.substring(1, viewName.length());
        }
        return prefix + viewName + postfix;
    }

    public boolean isRedirect(String viewName) {
        if (viewName.toLowerCase().startsWith(REDIRECT_PREFIX)) {
            return true;
        }
        return false;
    }

    public String getRedirectUrl(String viewName) {
        Precondition.isCheckNull(viewName);

        return viewName.substring(REDIRECT_PREFIX.length());
    }

    public String getLayOut(String viewName) {
        if (viewName.contains("/admin")) {
            return DEFAULT_ADMIN_LAYOUT;
        }
        return DEFAULT_SHOP_LAYOUT;
    }
}
