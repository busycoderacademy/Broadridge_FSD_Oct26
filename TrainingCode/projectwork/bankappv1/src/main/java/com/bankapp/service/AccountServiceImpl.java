package com.bankapp.service;

import com.bankapp.dto.Account;
import com.bankapp.repo.AccountRepo;

import java.util.List;

public class AccountServiceImpl implements  AccountService {

    private AccountRepo accountRepo;
    private NotificationService notificationService;

    public AccountServiceImpl(AccountRepo accountRepo, NotificationService notificationService) {
        this.accountRepo = accountRepo;
        this.notificationService = notificationService;
    }

    @Override
    public Account getAccountById(int id) {
        return accountRepo.getAccountById(id);
    }

    @Override
    public void transfer(int fromAccId, int toAccountId, double balance) {
        //deduce money from fromAccId
        Account fromAccount = getAccountById(fromAccId);
        fromAccount.setBalance(fromAccount.getBalance() - balance);
        accountRepo.updateAccount(fromAccount);

        Account toAccount = getAccountById(toAccountId);
        toAccount.setBalance(toAccount.getBalance() + balance);
        accountRepo.updateAccount(toAccount);

        notificationService.notifyUser("Transfer of " + balance + " from " + fromAccId + " to " + toAccountId);
        //add money to toAccountId
        //update both accounts in repo
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.getAllAccounts();
    }

    @Override
    public void deposit(int id, double balance) {
        Account account = getAccountById(id);
        account.setBalance(account.getBalance() + balance);
        accountRepo.updateAccount(account);
    }

    @Override
    public void withdraw(int id, double balance) {
        Account account = getAccountById(id);
        account.setBalance(account.getBalance() - balance);
        accountRepo.updateAccount(account);
    }
}
