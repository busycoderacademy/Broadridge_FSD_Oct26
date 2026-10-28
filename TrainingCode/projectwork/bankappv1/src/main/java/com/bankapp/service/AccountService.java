package com.bankapp.service;

import com.bankapp.dto.Account;

public interface AccountService {
    public Account getAccountById(int id);
    public void transfer(int fromAccId, int toAccountId, double balance);
}
