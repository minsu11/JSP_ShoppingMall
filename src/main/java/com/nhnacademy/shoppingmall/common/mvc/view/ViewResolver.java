package com.nhnacademy.shoppingmall.common.mvc.view;

import com.nhnacademy.shoppingmall.common.precondition.Precondition;

public class ViewResolver {

    public static final String DEFAULT_PREFIX = "/WEB-INF/views/";
    public static final String DEFAULT_POSTFIX = ".jsp";
    public static final String REDIRECT_PREFIX = "redirect:";
    public static final String DEFAULT_SHOP_LAYOUT = "/WEB-INF/views/layout/shop.jsp";
    public static final String DEFAULT_ADMIN_LAYOUT = "/WEB-INF/views/layout/admin.jsp";
    public static final String LAYOUT_CONTENT_HOLDER = "layout_content_holder";

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
        return postfix + viewName + postfix;
    }

    public boolean isRedirect(String viewName) {
        if (viewName.equals(REDIRECT_PREFIX)) {
            return true;
        }
        return false;
    }

    public String getRedirectUrl(String viewName) {
        //todo#6-3 REDIRECT_PREFIX를 제외한 url을 반환 합니다.

        return "";
    }

    public String getLayOut(String viewName) {

        /*todo#6-4 viewName에
           /admin/경로가 포함되었다면 DEFAULT_ADMIN_LAYOUT 반환 합니다.
           /admin/경로가 포함되어 있지않다면 DEFAULT_SHOP_LAYOUT 반환 합니다.
        */

        return DEFAULT_SHOP_LAYOUT;
    }
}
