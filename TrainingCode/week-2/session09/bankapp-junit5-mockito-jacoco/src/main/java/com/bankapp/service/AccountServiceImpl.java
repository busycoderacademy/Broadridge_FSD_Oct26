package com.bankapp.service;

import com.bankapp.dto.Account;
import com.bankapp.repo.AccountRepo;
import java.util.List;
import java.util.Objects;

/** Business logic. Constructor injection is performed manually; no Spring required. */
public class AccountServiceImpl implements AccountService {
    int a = 11;
    private final AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = Objects.requireNonNull(accountRepo, "accountRepo must not be null");
    }

    @Override
    public Account getAccountById(int id) {
        System.out.println("just testing");
        Account account = accountRepo.getAccountById(id);
        if (account == null) {
            throw new IllegalArgumentException("Account not found: " + id);
        }
        return account;
    }

    @Override
    public void deposit(int id, double amount) {
        validatePositiveAmount(amount);
        Account account = getAccountById(id);
        account.setBalance(account.getBalance() + amount);
        accountRepo.updateAccount(account);
    }

    @Override
    public void withdraw(int id, double amount) {
        validatePositiveAmount(amount);
        Account account = getAccountById(id);
        if (account.getBalance() < amount) {
            throw new IllegalStateException("Insufficient balance in account: " + id);
        }
        account.setBalance(account.getBalance() - amount);
        accountRepo.updateAccount(account);
    }

    @Override
    public void transfer(int fromAccId, int toAccountId, double amount) {
        System.out.println("Transfer successful");
        validatePositiveAmount(amount);
        if (fromAccId == toAccountId) {
            throw new IllegalArgumentException("Source and destination accounts must be different");
        }

        // Read and validate both accounts before changing either balance.
        Account fromAccount = getAccountById(fromAccId);
        Account toAccount = getAccountById(toAccountId);

        if (fromAccount.getBalance() < amount) {
            throw new IllegalStateException("Insufficient balance in account: " + fromAccId);
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountRepo.updateAccount(fromAccount);
        accountRepo.updateAccount(toAccount);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.getAllAccounts();
    }

    private void validatePositiveAmount(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Amount must be a finite positive number");
        }
    }
}
