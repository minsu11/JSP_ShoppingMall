package com.nhnacademy.shoppingmall.controller.admin;

import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.annotation.Transaction;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.common.util.FileUtil;
import com.nhnacademy.shoppingmall.image.entity.Image;
import com.nhnacademy.shoppingmall.image.service.ImageService;
import com.nhnacademy.shoppingmall.product.domain.Product;
import com.nhnacademy.shoppingmall.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * packageName    : com.nhnacademy.shoppingmall.controller.admin
 * fileName       : AdminProductRegisterPostController
 * author         : parkminsu
 * date           : 2024. 9. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 18.        parkminsu       최초 생성
 */

@Slf4j
@Transaction
@RequestMapping(method = RequestMapping.Method.POST,value = "/admin/product/register.do")
public class AdminProductRegisterPostController implements BaseController {

    private ProductService productService;
    private ImageService imageService;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)  {

        String number = req.getParameter("product-number");
        String name = req.getParameter("product-name");
        String description = req.getParameter("product-description");
        int cost = Integer.parseInt(req.getParameter("product-cost"));
        int inventory = Integer.parseInt(req.getParameter("product-inventory"));
        String path =null;
        try{
            path = FileUtil.fileSave(req.getPart("product-image"), FileUtil.PRODUCT_IMAGE_PATH, req.getServletContext());
        }catch (ServletException | IOException e){
            log.error(e.getMessage());

        }
        if(Objects.isNull(number) || Objects.isNull(name) || Objects.isNull(description) || Objects.isNull(path)) {
            throw new NullPointerException("request value is null");
        }

        if(cost <0 || inventory < 0) {
            throw new IllegalArgumentException("cost or inventory is negative");
        }

        imageService = (ImageService) req.getServletContext().getAttribute("imageService");
        productService =(ProductService) req.getServletContext().getAttribute("productService");

        Product product = Product.builder()
                .name(name)
                .number(number)
                .description(description)
                .unitCost(cost)
                .inventory(inventory)
                .createdAt(LocalDateTime.now())
                .build();

        try{
            productService.createProduct(product);
            imageService.createImage(path, product.getNumber());
        }catch (IllegalArgumentException e){
            log.error(e.getMessage());
            return "redirect:/admin/product/register.do";
        }

        return "redirect:/admin/product/list.do";
    }


}
