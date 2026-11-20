package com.productapp.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAppErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String toContact;
}