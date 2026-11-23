package com.bankapp.controller;

import com.bankapp.dto.ErrorResponse;
import com.bankapp.exceptions.BankAccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice //interally using throws advace
public class ExceptionHandlerController {

    //ResponseEntity: hold 2 things data + http status code
    @ExceptionHandler(BankAccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle404(BankAccountNotFoundException ex){
        String message= "bank account not found: "+ex.getMessage();
        ErrorResponse errorResponse=ErrorResponse.builder()
                .errorMessage(ex.getMessage())
                .timeStamp(LocalDateTime.now())
                .toContact("rgpta.mtech@gmail.com")
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handle500(Exception ex){
//        ErrorResponse errorResponse=ErrorResponse.builder()
//                .errorMessage("Please try after some time")
//                .timeStamp(LocalDateTime.now())
//                .toContact("rgpta.mtech@gmail.com")
//                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                .build();
//
//        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//    }
}
