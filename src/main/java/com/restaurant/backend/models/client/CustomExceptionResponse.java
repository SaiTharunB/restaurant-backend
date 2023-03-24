package com.restaurant.backend.models.client;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class CustomExceptionResponse {
    private String message;
    private Integer code;

    private LocalDateTime timestamp;
    private String reason;

    public CustomExceptionResponse(String message,HttpStatus httpStatus){
        this.message=message;
        this.code= httpStatus.value();
        this.reason=httpStatus.getReasonPhrase();
        this.timestamp=LocalDateTime.now();
    }
}
