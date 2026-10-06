package com.hamitmizrak.controller.api;

import org.springframework.web.multipart.MultipartFile;

// D: Dto
// E: Entity
public interface IImageApi<D,E>{

    // IMAGE
    // IMAGE CREATE
    public D objectServiceCreateWithFile(D d, MultipartFile multipartFile);

    // IMAGE UPDATE
    public D objectServiceUpdateWithFile(Long id, D d, MultipartFile multipartFile);
}
