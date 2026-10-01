package com.hamitmizrak.file_upload;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final FileStorageService storage;

    public String saveRegisterImage(MultipartFile file) {
        return storage.store(file, "register");
    }

    public String saveBlogImage(MultipartFile file) {
        return storage.store(file, "blog");
    }

    public void deleteByUrl(String relativeUrl) {
        storage.delete(relativeUrl);
    }
}
