package com.hamitmizrak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Status Code      : 403
// FORBIDDEN        : Yetkilendirme
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class _403_ForbiddenException extends RuntimeException {

    // Parametreli Constructor
    public _403_ForbiddenException(String message) {
        super(message);
    } //end parametreli constructor

} //end class
