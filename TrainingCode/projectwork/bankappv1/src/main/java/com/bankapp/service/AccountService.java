package com.bankapp.service;

import com.bankapp.dto.Account;

import java.util.List;

public interface AccountService {
    public Account getAccountById(int id);
    public void transfer(int fromAccId, int toAccountId, double balance);
    public List<Account> getAllAccounts();
    public void deposit(int id, double balance);
    public void withdraw(int id, double balance);
}
