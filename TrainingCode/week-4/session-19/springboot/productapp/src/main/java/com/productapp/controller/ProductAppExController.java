package com.productapp.controller;

import com.productapp.dto.ProductAppErrorResponse;
import com.productapp.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice //AOP
public class ProductAppExController {

    @Value("${product.team}")
    private String teamName;

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductAppErrorResponse> handle404(ProductNotFoundException ex){
        ProductAppErrorResponse errorResponse=ProductAppErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(ex.getMessage())
                .toContact(teamName)
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    //MethodArgumentNotValidException

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProductAppErrorResponse> handle400(MethodArgumentNotValidException ex){
        String cause = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ProductAppErrorResponse errorResponse=ProductAppErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(cause)
                .toContact(teamName)
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ProductAppErrorResponse> handle500(Exception ex){
//        ProductAppErrorResponse errorResponse=ProductAppErrorResponse.builder()
//                .timestamp(LocalDateTime.now())
//                .error("Pls try after some time")
//                .toContact(teamName)
//                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                .build();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//    }
}
