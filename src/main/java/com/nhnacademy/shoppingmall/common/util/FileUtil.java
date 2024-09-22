package com.nhnacademy.shoppingmall.common.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * packageName    : com.nhnacademy.shoppingmall.common.util
 * fileName       : FileUtil
 * author         : parkminsu
 * date           : 2024. 9. 19.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 19.        parkminsu       최초 생성
 */
@Slf4j
public final class FileUtil {
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    private static String LOCATION = "./src/main/resources/image";
    public static final String PRODUCT_IMAGE_PATH = "/resources/product";


    public static String fileSave(Part part, String uploadPath, ServletContext context) throws ServletException, IOException {
        String contentDisposition = part.getHeader(CONTENT_DISPOSITION);
        String path = null;
        if (contentDisposition.contains("filename=")) {
            String fileName = extractFileName(contentDisposition);
            String realPath = context.getRealPath(uploadPath);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            path = LOCATION+getUploadPath(uploadPath) + File.separator +formatter.format(LocalDateTime.now()) +fileName;
            log.debug(realPath);

            if (part.getSize() > 0) {
                part.write(realPath);
                part.delete();
            }
        }
        return path;
    }

    private static String getUploadPath(String uploadPath) {
        if(uploadPath.startsWith("/")) {
            return uploadPath;
        }
        return "/"+uploadPath;
    }
    private static String extractFileName(String contentDisposition) {
        log.error("contentDisposition:{}",contentDisposition);
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=")+2, token.length()-1);
            }
        }
        return null;
    }
}
