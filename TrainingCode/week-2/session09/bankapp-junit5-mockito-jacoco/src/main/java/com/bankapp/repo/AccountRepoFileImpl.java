package com.bankapp.repo;

import com.bankapp.dto.Account;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Kept to match the original training project name.
 * NOTE: This class currently uses an in-memory Map; it does NOT read/write a file.
 */
public class AccountRepoFileImpl implements AccountRepo {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public AccountRepoFileImpl() {
        accounts.put(1, new Account(1, "raj", 2_000));
        accounts.put(2, new Account(2, "ekta", 2_000));
    }

    @Override
    public Account getAccountById(int id) { return accounts.get(id); }

    @Override
    public void updateAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return new LinkedList<>(accounts.values());
    }
}
