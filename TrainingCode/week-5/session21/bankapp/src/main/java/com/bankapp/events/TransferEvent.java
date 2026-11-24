package com.bankapp.events;

import com.bankapp.dto.TransactionType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TransferEvent {
    private int fromAccountId;
    private int toAccountId;
    private Double amount;
    private TransactionType txType;
    private LocalDateTime dateTime;
}