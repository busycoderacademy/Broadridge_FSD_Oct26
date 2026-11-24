package com.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferDto {
    private int fromAccountId;
    private int toAccountId;
    private Double amount;
    private TransactionType txType;
}