package com.bankapp.repo;

import com.bankapp.dto.Account;

import java.util.List;

public interface AccountRepo {
    public Account getAccountById(int id);
    public void updateAccount(Account account);
    public List<Account> getAllAccounts();
}
