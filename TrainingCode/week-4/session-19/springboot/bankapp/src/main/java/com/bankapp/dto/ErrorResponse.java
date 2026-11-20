package com.bankapp.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private String errorMessage;
    private LocalDateTime timeStamp;
    private String toContact;
    private int statusCode;

}