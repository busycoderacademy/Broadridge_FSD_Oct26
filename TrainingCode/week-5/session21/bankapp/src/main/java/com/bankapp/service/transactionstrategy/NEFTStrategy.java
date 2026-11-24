package com.bankapp.service.transactionstrategy;

import com.bankapp.entities.Account;
import org.springframework.stereotype.Service;

@Service("NEFT")
public class NEFTStrategy implements TransactionStrategy {
    @Override
    public void transfer(Account from, Account to, double amount) {
        System.out.println("Processing NEFT transfer...");
    }
}