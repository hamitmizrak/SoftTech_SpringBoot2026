package com.hamitmizrak.controller.api;

import com.hamitmizrak.error.ApiResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

// D: Dto
public interface IImageApi<D>{

    // IMAGE
    // IMAGE CREATE
    public ResponseEntity<ApiResult<?>> objectApiCreateWithFile(String json, MultipartFile multipartFile);

    // IMAGE UPDATE
    public ResponseEntity<ApiResult<?>> objectApiUpdateWithFile(Long id, String json, MultipartFile multipartFile);
}
