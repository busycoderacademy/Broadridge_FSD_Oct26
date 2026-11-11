package com.bankapp.repo;

import com.bankapp.dto.Account;

import java.util.List;

public interface AccountRepo {
    public List<Account> getAccounts();
    public  Account getAccountById(int id);
    public void update(Account account);
    public void save(Account account);
}
