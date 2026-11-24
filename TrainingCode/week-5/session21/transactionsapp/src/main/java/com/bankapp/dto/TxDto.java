package com.bankapp.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TxDto {
    private int id;
    private double txAmount;
    private String txType;
    private LocalDateTime localDateTime;
}
