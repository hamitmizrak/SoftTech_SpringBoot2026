package com.hamitmizrak.file_upload;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    /**
     * @param file     Multipart dosya
     * @param module   "register" veya "blog" gibi alt klasör
     * @return         Veritabanına kaydedilecek relative URL (örn: /upload/register/2025/08/24/uuid.jpg)
     */
    String store(MultipartFile file, String module);

    void delete(String relativeUrl); // /upload/... ile başlar
    Resource loadAsResource(String relativeUrl);
}
