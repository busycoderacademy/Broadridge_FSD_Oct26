package com.bankapp.service;

import com.bankapp.dto.Account;
import com.bankapp.repo.AccountRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
//SL=BL+ CCC (non fuctional req) sec tx mgt logging caching ., AOP can do this for me, proxy deign pattern
@Service(value = "accountService")
public class AccountServiceImpl implements  AccountService {

    @Value(value = "sbi")
    private String  bankName;

    private Logger logger= LoggerFactory.getLogger(AccountServiceImpl.class);
   // @Autowired //field injection
    private AccountRepo accountRepo;

//    @Autowired //setter injection: if dep is not mandaortory
//    public void setAccountRepo(AccountRepo accountRepo) {
//        this.accountRepo = accountRepo;
//    }

    @Autowired //ctr injection: for mandatory dep
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("after bean is created accountservice");
    }

    @PreDestroy
    public void preDestory(){
        System.out.println("before destoyring accountservice");
    }
    @Override
    public Account getAccountById(int id) {
        long start=System.currentTimeMillis();
        Account account= accountRepo.getAccountById(id);
        long end=System.currentTimeMillis();
        logger.info("time taken to execute getAccountById is "+ (end-start)+" ms");
        return account;
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
