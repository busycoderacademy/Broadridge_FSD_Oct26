package com.bankapp.service;

import com.bankapp.entities.Account;
import com.bankapp.dto.TransactionType;
import com.bankapp.events.TransferEvent;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import com.bankapp.service.transactionstrategy.TransactionStrategy;
import com.bankapp.service.transactionstrategy.TransactionStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountServiceImpl implements  AccountService {

    private AccountRepo accountRepo;
    private NotificationService notificationService;
    private TransactionStrategyFactory transactionStrategyFactory;

    private ApplicationEventPublisher eventPublisher;

    private KafkaTemplate<String, TransferEvent> kafkaTemplate;


    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo, NotificationService notificationService,
                              TransactionStrategyFactory transactionStrategyFactory, ApplicationEventPublisher eventPublisher,
                              KafkaTemplate<String, TransferEvent> kafkaTemplate ) {
        this.accountRepo = accountRepo;
        this.notificationService = notificationService;
        this.transactionStrategyFactory = transactionStrategyFactory;
        this.eventPublisher=eventPublisher;
        this.kafkaTemplate=kafkaTemplate;
    }

    @Override
    public Account getAccountById(int id) {
        Account account= accountRepo.getAccountById(id);
        if(account==null)
            throw  new
                    BankAccountNotFoundException("account with id "+ id +" is not found");

        return  account;
    }

    @Override
    public void transfer(int fromAccId, int toAccountId, double balance,
                         TransactionType transactionType) {
        //deduce money from fromAccId
        Account fromAccount = getAccountById(fromAccId);
        fromAccount.setBalance(fromAccount.getBalance() - balance);
        accountRepo.updateAccount(fromAccount);

        Account toAccount = getAccountById(toAccountId);
        toAccount.setBalance(toAccount.getBalance() + balance);
        accountRepo.updateAccount(toAccount);

        notificationService.notifyUser("Transfer of " + balance + " from " + fromAccId + " to " + toAccountId);

        TransactionStrategy strategy = transactionStrategyFactory.getStrategy(transactionType);
        strategy.transfer(fromAccount, toAccount, balance);

        TransferEvent transferEvent=TransferEvent.builder()
                .toAccountId(toAccount.getId())
                .fromAccountId(fromAccount.getId())
                .txType(transactionType)
                .dateTime(LocalDateTime.now())
                .build();

        eventPublisher.publishEvent(transferEvent);
        CompletableFuture<SendResult<String, TransferEvent>> send =
                kafkaTemplate.send("fund-transfer-events", transferEvent);//non blocking

        //add money to toAccountId
        //update both accounts in repo
    }

    @Override
    public List<Account> getAllAccounts() {
//        if (1==1)
//            throw new RuntimeException("some db error");
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
