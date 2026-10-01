package com.hamitmizrak.file_upload;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

@Data
@Configuration
@ConfigurationProperties(prefix = "file")
public class FileProps {

    /** application.yml -> file.upload-dir */
    private String uploadDir = "upload";

    /** application.yml -> file.base-url (örn: http://localhost:4444) */
    private String baseUrl;

    public Path getUploadRoot() {
        return Paths.get(uploadDir).toAbsolutePath().normalize();
    }
}
