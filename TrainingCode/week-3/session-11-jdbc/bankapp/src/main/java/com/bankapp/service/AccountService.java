package com.bankapp.service;

import com.bankapp.dto.Account;

import java.util.List;

public interface AccountService {
    public List<Account> getAccounts();
    public  Account getAccountById(int id);
    public void deposit(int id, double amount);
    public void withdraw(int id, double amount);
    public void transfer(int fromId, int toId, double amount);
}
