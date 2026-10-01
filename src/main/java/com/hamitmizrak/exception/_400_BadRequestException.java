package com.hamitmizrak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Status Code : 400
// BAD_REQUEST : Kötü İstek
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class _400_BadRequestException extends RuntimeException {

    // Parametreli Constructor
    public _400_BadRequestException(String message) {
        super(message);
    } //end parametreli constructor

} //end class
