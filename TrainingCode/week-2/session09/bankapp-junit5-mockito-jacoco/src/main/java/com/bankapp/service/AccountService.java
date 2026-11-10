package com.bankapp.service;

import com.bankapp.dto.Account;
import java.util.List;

public interface AccountService {
    Account getAccountById(int id);
    void transfer(int fromAccId, int toAccountId, double amount);
    List<Account> getAllAccounts();
    void deposit(int id, double amount);
    void withdraw(int id, double amount);
}
