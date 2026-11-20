package com.bankapp.service.transactionstrategy;

import com.bankapp.dto.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("NEFT")
public class NEFTStrategy implements TransactionStrategy {
    @Override
    public void transfer(Account from, Account to, double amount) {
        System.out.println("Processing NEFT transfer...");
    }
}