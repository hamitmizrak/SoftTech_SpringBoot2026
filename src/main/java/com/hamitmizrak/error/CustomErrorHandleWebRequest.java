package com.hamitmizrak.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LOMBOK
@Log4j2 // Loglama için Lombok annotation
@RequiredArgsConstructor // Final field'ları constructor ile inject eder

// API
@RestController // Bu sınıf bir REST API controller'ıdır
@CrossOrigin // CORS izinleri verir (farklı origin'den gelen requestler)
public class CustomErrorHandleWebRequest implements ErrorController {

    /*
        ErrorAttributes kullanımı için 3 yöntem:

        1. Field Injection (Autowired ile) --> önerilmez
        //@Autowired
        //private ErrorAttributes errorAttributes;

        2. Constructor Injection (manuel) --> kullanılabilir
        //private ErrorAttributes errorAttributes;
        /*
        @Autowired
        public CustomErrorHandleWebRequest(ErrorAttributes errorAttributes) {
            this.errorAttributes = errorAttributes;
        }
       3. Lombok Injection (Recommended) --> final field + @RequiredArgsConstructor
    */
    private final ErrorAttributes errorAttributes;

    /**
     * Hata endpoint'i
     * Spring Boot'un default /error endpoint'i için handle method
     * Tüm global hataları merkezi olarak ApiResult formatında döndürür
     *
     * @param webRequest WebRequest: HTTP request abstraction
     * @return ApiResult<Object>: Hata response'u
     */
    // http://localhost:4444/error
    @RequestMapping("/error")
    public ApiResult<Object> handleErrorMethod(WebRequest webRequest) {

        // Spring Boot'un ErrorAttributes'ından tüm hata detaylarını al
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(
                webRequest,
                ErrorAttributeOptions.of(
                        ErrorAttributeOptions.Include.MESSAGE,       // Hata mesajını al
                        ErrorAttributeOptions.Include.BINDING_ERRORS // Validation hatalarını al
                )
        );

        // Status kodunu integer olarak al, null ise 0
        int status = attributes.get("status") == null ? 0 : Integer.parseInt(attributes.get("status").toString());

        // Hata mesajını ve request path'ini al
        String message = (String) attributes.get("message");
        String path = (String) attributes.get("path");

        // Validation hataları
        Map<String, Object> validationErrors = null;

        if (attributes.containsKey("errors")) {
            // FieldError listesi olarak cast et
            List<FieldError> fieldErrors = (List<FieldError>) attributes.get("errors");
            validationErrors = new HashMap<>();
            for (FieldError fieldError : fieldErrors) {
                // Field ve message'ı map içine ekle
                validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }

        // ApiResult instance
        ApiResult<Object> apiResult;

        // HTTP status koduna göre ApiResult.Status enum'ını belirle
        ApiResult.Status apiStatus;
        switch (status) {
            case 200 -> apiStatus = ApiResult.Status.SUCCESS;
            case 400 -> apiStatus = ApiResult.Status.UNPROCESSABLE;
            case 401 -> apiStatus = ApiResult.Status.UNAUTHORIZED;
            case 403 -> apiStatus = ApiResult.Status.FORBIDDEN;
            case 404 -> apiStatus = ApiResult.Status.NOT_FOUND;
            case 500 -> apiStatus = ApiResult.Status.SERVER_ERROR;
            default -> apiStatus = ApiResult.Status.ERROR;
        }

        // ApiResult'u build et
        apiResult = ApiResult.<Object>builder()
                .status(apiStatus)
                .message(message)
                .path(path)
                .errors(validationErrors) // Validation hataları varsa ekle
                .build();

        return apiResult; // Response olarak döndür
    }

    /**
     * Test endpoint
     * http://localhost:4444/test/apiresult
     * Bu endpoint isteğe bağlı olarak hata üretmek için kullanılabilir
     */
    @GetMapping("/test/apiresult")
    public String errorTest() {
        throw new RuntimeException("İsteyerek Hata Gönder");
    }
}
