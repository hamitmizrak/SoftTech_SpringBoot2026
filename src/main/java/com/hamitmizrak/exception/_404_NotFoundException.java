package com.hamitmizrak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Status Code           : 404
// NOT FOUND             : Bulunamadı
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class _404_NotFoundException extends RuntimeException {

    public _404_NotFoundException(String message) {
        super(message);
    }
}
