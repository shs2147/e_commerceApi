package com.example.demo.exceptionController;

import com.example.demo.exception.productnotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class expController {
    @ExceptionHandler(value=productnotFoundException.class)
    public final ResponseEntity<String> handleproductnotFoundException(productnotFoundException exception)
    {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
