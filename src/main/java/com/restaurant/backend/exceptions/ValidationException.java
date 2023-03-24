package com.restaurant.backend.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ValidationException extends Exception{
    private static final long serialVersionUID = 1L;
    private HttpStatus status;

    public ValidationException(String message)
    {
        super(message);
        this.status=HttpStatus.BAD_REQUEST;
    }
}
