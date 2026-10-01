package com.hamitmizrak.config;

import com.hamitmizrak.file_upload.FileProps;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

// LOMBOK
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final FileProps fileProps;

    /**
     * file.upload-dir altında saklanan dosyaları HTTP üzerinden yayınlar.
     * Örnek fiziksel dosya:
     *   ./upload/blog/example.png
     * Örnek public adres:
     *   http://localhost:5555/upload/blog/example.png
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path uploadRoot = fileProps.getUploadRoot().toAbsolutePath().normalize();

        try {
            Files.createDirectories(uploadRoot);
            Files.createDirectories(uploadRoot.resolve("blog"));
        } catch (IOException ex) {
            throw new IllegalStateException("Upload klasörü oluşturulamadı: " + uploadRoot, ex);
        }

        String uploadUri = uploadRoot.toUri().toString();
        if (!uploadUri.endsWith("/")) {
            uploadUri = uploadUri + "/";
        }

        registry
                .addResourceHandler("/upload/**", "/uploads/**")
                .addResourceLocations(uploadUri)
                // Güncellenen görsellerin tarayıcı önbelleğinde eski kalmasını engeller.
                .setCacheControl(CacheControl.noStore())
                .resourceChain(false);
    }

    // CORS (Cross Origin Resource Sharing)
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry
                .addMapping("/**")
                .allowedOriginPatterns(
                        "http://localhost:*",
                        "http://127.0.0.1:*"
                )
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("Content-Disposition", "Content-Type")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
        viewResolverRegistry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("tr", "TR"));
        return localeResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName("lang");
        interceptorRegistry.addInterceptor(localeInterceptor);
    }

} // end WebConfig
