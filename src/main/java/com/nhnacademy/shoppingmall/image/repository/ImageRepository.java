package com.nhnacademy.shoppingmall.image.repository;


import com.nhnacademy.shoppingmall.image.entity.Image;

/**
 * packageName    : com.nhnacademy.shoppingmall.file.repository
 * fileName       : FileRepository
 * author         : parkminsu
 * date           : 2024. 9. 19.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 19.        parkminsu       최초 생성
 */
public interface ImageRepository {
    Integer saveImage(Image image);

}
