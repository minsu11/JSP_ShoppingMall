package com.nhnacademy.shoppingmall.image.service.impl;

import com.nhnacademy.shoppingmall.image.entity.Image;
import com.nhnacademy.shoppingmall.image.repository.ImageRepository;
import com.nhnacademy.shoppingmall.image.service.ImageService;
import com.nhnacademy.shoppingmall.product.domain.Product;
import com.nhnacademy.shoppingmall.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * packageName    : com.nhnacademy.shoppingmall.file.service.impl
 * fileName       : FileServiceImpl
 * author         : parkminsu
 * date           : 2024. 9. 19.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 19.        parkminsu       최초 생성
 */
@Slf4j
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ProductRepository productRepository;
    @Override
    public void createImage(String path, String productNumber) {
        if(Objects.isNull(path) || Objects.isNull(productNumber)) {
            throw new NullPointerException("image is null");
        }
        Product product = productRepository.findProductByNumber(productNumber)
                .orElseThrow(() -> new RuntimeException("product not found"));
        Image image = Image.builder()
                .productId(product.getId())
                .imagePath(path)
                .createAt(LocalDateTime.now())
                .build();
        int result = imageRepository.saveImage(image);

        if(result <= 0){
            throw new IllegalArgumentException("image not saved");
        }
    }


}
