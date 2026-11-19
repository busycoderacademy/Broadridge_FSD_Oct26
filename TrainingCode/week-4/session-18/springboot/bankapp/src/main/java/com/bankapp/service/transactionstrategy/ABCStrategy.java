package com.bankapp.service.transactionstrategy;

import com.bankapp.dto.Account;
import org.springframework.stereotype.Service;

@Service("ABC")
public class ABCStrategy implements TransactionStrategy {
    @Override
    public void transfer(Account from, Account to, double amount) {
        System.out.println("Processing ABC transfer...");
    }
}