package com.bankapp.repo;

import com.bankapp.dto.Account;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** In-memory repository used for the training exercise. */
public class AccountRepoMapImpl implements AccountRepo {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public AccountRepoMapImpl() {
        accounts.put(1, new Account(1, "raj", 2_000));
        accounts.put(2, new Account(2, "ekta", 2_000));
    }

    @Override
    public Account getAccountById(int id) {
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
