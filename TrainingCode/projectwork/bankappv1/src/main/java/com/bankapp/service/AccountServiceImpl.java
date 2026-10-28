package com.bankapp.service;

import com.bankapp.dto.Account;
import com.bankapp.repo.AccountRepo;
import com.bankapp.repo.AccountRepoJdbcImpl;
import com.bankapp.repo.AccountRepoMapImpl;

public class AccountServiceImpl implements  AccountService {

    private AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
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

        //add money to toAccountId
        //update both accounts in repo
    }
}
