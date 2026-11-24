package com.bankapp.service.transactionstrategy;

import com.bankapp.entities.Account;

public interface TransactionStrategy {
    void transfer(Account from, Account to, double amount);
}