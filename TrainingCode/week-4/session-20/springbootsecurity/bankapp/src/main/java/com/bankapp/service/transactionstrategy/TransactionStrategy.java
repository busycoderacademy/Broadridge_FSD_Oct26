package com.bankapp.service.transactionstrategy;

import com.bankapp.dto.Account;

import java.math.BigDecimal;

public interface TransactionStrategy {
    void transfer(Account from, Account to, double amount);
}