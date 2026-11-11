package com.bankapp.controller;


import com.bankapp.dto.Account;
import com.bankapp.service.AccountService;
import com.bankapp.service.AccountServiceImpl;

import java.util.List;

public class AccountTester {
    public static void main(String[] args) {
        AccountService accountService=new AccountServiceImpl();
        accountService.save(new Account("raj",1000));
        accountService.save(new Account("ekta",1000));
//        List<Account> accounts=accountService.getAccounts();
//
//        accounts.forEach(System.out::println);
        //get account by  id
//        Account accountById=accountService.getAccountById(1);
//        System.out.println(accountById);
        accountService.deposit(1, 50);
    }
}
