package com.hamitmizrak.file_upload;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {

    private static final List<String> ALLOWED_MIME = List.of(
            "image/jpeg", "image/png", "image/webp", "image/gif"
    );

    private final FileProps fileProps;

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(fileProps.getUploadRoot());
        } catch (IOException e) {
            throw new FileStorageException("Upload klasörü oluşturulamadı", e);
        }
    }

    @Override
    public String store(MultipartFile file, String module) {
        if (file == null || file.isEmpty()) {
            throw new FileStorageException("Dosya boş olamaz.");
        }
        String contentType = file.getContentType();
        if (contentType == null || ALLOWED_MIME.stream().noneMatch(contentType::equalsIgnoreCase)) {
            throw new FileStorageException("Sadece görüntü dosyaları yüklenebilir (jpeg, png, webp, gif).");
        }

        String ext = getExtension(file.getOriginalFilename());
        String filename = UUID.randomUUID() + (ext.isEmpty() ? "" : "." + ext);

        LocalDate today = LocalDate.now();
        Path targetDir = fileProps.getUploadRoot().resolve(Paths.get(
                module,
                String.valueOf(today.getYear()),
                String.format("%02d", today.getMonthValue()),
                String.format("%02d", today.getDayOfMonth())
        )).normalize();

        try {
            Files.createDirectories(targetDir);
            Path target = targetDir.resolve(filename).normalize();
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new FileStorageException("Dosya kaydedilirken hata oluştu.", e);
        }

        // Veritabanına kaydedilecek relative URL:
        String relativeUrl = "/upload/" + module + "/" + today.getYear() + "/"
                + String.format("%02d", today.getMonthValue()) + "/"
                + String.format("%02d", today.getDayOfMonth()) + "/" + filename;
        return relativeUrl;
    }

    @Override
    public void delete(String relativeUrl) {
        if (relativeUrl == null || !relativeUrl.startsWith("/upload/")) return;

        Path filePath = relativeToFileSystem(relativeUrl);
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new FileStorageException("Dosya silinemedi: " + relativeUrl, e);
        }
    }

    @Override
    public Resource loadAsResource(String relativeUrl) {
        if (relativeUrl == null || !relativeUrl.startsWith("/upload/")) {
            throw new MyFileNotFoundException("Geçersiz yol.");
        }
        Path file = relativeToFileSystem(relativeUrl);
        if (!Files.exists(file)) {
            throw new MyFileNotFoundException("Dosya bulunamadı: " + relativeUrl);
        }
        return new FileSystemResource(file.toFile());
    }

    private Path relativeToFileSystem(String relativeUrl) {
        // /upload/... -> upload/...  (root ile birleştir)
        String trimmed = relativeUrl.replaceFirst("^/+", ""); // upload/...
        Path absolute = fileProps.getUploadRoot().getParent().resolve(trimmed).normalize();
        return absolute;
    }

    private String getExtension(String filename) {
        if (!StringUtils.hasText(filename)) return "";
        String clean = Paths.get(filename).getFileName().toString();
        int dot = clean.lastIndexOf('.');
        return (dot >= 0 && dot < clean.length() - 1) ? clean.substring(dot + 1).toLowerCase() : "";
    }
}


class FileStorageException extends RuntimeException {
    public FileStorageException(String message) { super(message); }
    public FileStorageException(String message, Throwable cause) { super(message, cause); }
}


class MyFileNotFoundException extends RuntimeException {
    public MyFileNotFoundException(String message) { super(message); }
}