package com.restaurant.backend.models.client;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomExceptionResponse  {
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
