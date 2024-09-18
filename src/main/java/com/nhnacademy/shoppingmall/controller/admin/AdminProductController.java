package com.nhnacademy.shoppingmall.controller.admin;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.annotation.Transaction;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.product.dto.AdminPageProductInfo;
import com.nhnacademy.shoppingmall.product.service.ProductService;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * packageName    : com.nhnacademy.shoppingmall.controller.admin
 * fileName       : AdminProductController
 * author         : parkminsu
 * date           : 2024. 9. 16.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 16.        parkminsu       최초 생성
 */
@Transaction
@RequestMapping(method = RequestMapping.Method.GET, value = "/admin/product/list.do")
public class AdminProductController implements BaseController {
    private ProductService productService;

    // 관리자 페이지에서 상품 목록을 보여주는 곳
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        productService =(ProductService) req.getServletContext().getAttribute("productService");

        List<AdminPageProductInfo> adminPageProductInfoList = productService.getAdminPageProductInfoList();
        req.setAttribute("productList", adminPageProductInfoList);

        return "shop/admin/admin-product-list";
    }
}
