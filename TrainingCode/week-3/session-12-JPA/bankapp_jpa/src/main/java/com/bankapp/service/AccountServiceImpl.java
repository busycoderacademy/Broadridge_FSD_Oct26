package com.bankapp.service;

import com.bankapp.dto.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import com.bankapp.repo.AccountRepoJpaImpl;

import java.util.List;

public class AccountServiceImpl implements AccountService{

    private AccountRepo accountRepo;

    public  AccountServiceImpl(){
        accountRepo=new AccountRepoJpaImpl();//loose coupling as of now, spring
    }

    @Override
    public List<Account> getAccounts() {
        return  accountRepo.getAccounts();
    }

    @Override
    public Account getAccountById(int id) {
        Account account=accountRepo.getAccountById(id);
        if(account==null){
            throw new BankAccountNotFoundException("Account not found");
        }
        return account;
    }

    @Override
    public void deposit(int id, double amount) {
        Account accountToUpdate=getAccountById(id);
        accountToUpdate.setBalance(accountToUpdate.getBalance()+amount);
        accountRepo.update(accountToUpdate);
    }

    @Override
    public void withdraw(int id, double amount) {
        Account accountToUpdate=getAccountById(id);
        accountToUpdate.setBalance(accountToUpdate.getBalance()-amount);
        accountRepo.update(accountToUpdate);
    }

    @Override
    public void transfer(int fromId, int toId, double amount) {
    //try it
    }

    @Override
    public void save(Account account) {
        accountRepo.save(account);
    }
}
