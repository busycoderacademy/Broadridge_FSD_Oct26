package com.bankapp.repo;

import com.bankapp.dto.Account;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AccountRepoMapImpl implements  AccountRepo {
    private Map<Integer, Account> accounts;

    public AccountRepoMapImpl() {
        accounts = new HashMap<>();
        accounts.put(1, new Account(1, "raj", 2000));
        accounts.put(2, new Account(2, "ekta", 2000));
    }
    @Override
    public Account getAccountById(int id) {
        System.out.println("map wala implementation");
        return accounts.get(id);
    }

    @Override
    public void updateAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return new LinkedList<>(accounts.values());
    }
}
