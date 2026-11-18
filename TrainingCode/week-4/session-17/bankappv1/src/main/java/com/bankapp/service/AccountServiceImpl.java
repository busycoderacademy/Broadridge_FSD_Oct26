package com.bankapp.service;

import com.bankapp.dto.Account;
import com.bankapp.exceptions.BarEx;
import com.bankapp.exceptions.FooEx;
import com.bankapp.repo.AccountRepo;
import com.bankapp.repo.AccountRepoMapImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service(value = "accountService") //singleton
@Scope("singleton")
//@Transactional(propagation =  Propagation.REQUIRED,
//        isolation = Isolation.SERIALIZABLE, noRollbackFor = {FooEx.class},
// rollbackFor = {BarEx.class}, timeout = 1)
@Transactional(readOnly = true)
//powerful all tx u can do with this ACID
public class AccountServiceImpl implements  AccountService {

    private AccountRepo accountRepo;
    private NotificationService notificationService;


    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo, NotificationService notificationService) {
        this.accountRepo = accountRepo;
        this.notificationService=notificationService;
    }

    @Override
    public Account getAccountById(int id) {
        notificationService.sendNotification("you have vertified balance");
        return accountRepo.getAccountById(id);
    }


    @Transactional(readOnly = false)
    @Override
    public void transfer(int fromAccId, int toAccountId, double balance)throws BarEx {
        //deduce money from fromAccId

        Account fromAccount = getAccountById(fromAccId);
        fromAccount.setBalance(fromAccount.getBalance() - balance);
        accountRepo.updateAccount(fromAccount);


        Account toAccount = getAccountById(toAccountId);
        toAccount.setBalance(toAccount.getBalance() + balance);
        accountRepo.updateAccount(toAccount);
        notificationService.sendNotification("fund is transfer");

        //if ex is unchecked then i will rollback otherwise u tell me
        if(1==1)
            throw new BarEx("some Foo Ex ex");

          //add money to toAccountId
        //update both accounts in repo

    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.getAllAccounts();
    }

    @Transactional(readOnly = false)
    @Override
    public void deposit(int id, double balance) {
        Account account = getAccountById(id);
        account.setBalance(account.getBalance() + balance);
        accountRepo.updateAccount(account);
    }

    @Transactional(readOnly = false)
    @Override
    public void withdraw(int id, double balance) {
        Account account = getAccountById(id);
        account.setBalance(account.getBalance() - balance);
        accountRepo.updateAccount(account);
    }
}
