package com.restaurant.backend.exceptions;

import com.restaurant.backend.models.client.CustomExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=ValidationException.class)
    public ResponseEntity<CustomExceptionResponse> validationExceptionHandler(ValidationException validationException){
            return new ResponseEntity<>(new CustomExceptionResponse(validationException.getMessage(),validationException.getStatus()),validationException.getStatus());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity constrantViolationHandler(ConstraintViolationException exception){
        return new ResponseEntity<>(new CustomExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity  handleErrors(MethodArgumentNotValidException exception){
        Map<String,String> errors= new LinkedHashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        String message = errors.entrySet().stream().map(e->e.getValue()).collect(Collectors.joining(", "));
        return new ResponseEntity<>(new CustomExceptionResponse(message,HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }
}
