package com.hamitmizrak.business.services;

import org.springframework.web.multipart.MultipartFile;

// D: Dto
// E: Entity
public interface IImageService<D,E>{

    // IMAGE
    // IMAGE CREATE
    public D objectServiceCreateWithFile(D d, MultipartFile multipartFile);

    // IMAGE UPDATE
    public D objectServiceUpdateWithFile(Long id, D d, MultipartFile multipartFile);
}
