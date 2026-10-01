package com.hamitmizrak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Status Code           : 500
// INTERNAL_SERVER_ERROR : Server Hatası
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class _500_IntervalServerException extends RuntimeException {

    // Parametreli Constructor
    public _500_IntervalServerException(String message) {
        super(message);
    } //end parametreli constructor

} //end class
