package com.bankapp.controller;

import com.bankapp.repo.AccountRepo;
import com.bankapp.repo.AccountRepoMapImpl;
import com.bankapp.service.AccountService;
import com.bankapp.service.AccountServiceImpl;

public class Main {
    public static void main(String[] args) {
        // Manual dependency injection: no Spring container is involved.
        AccountRepo repository = new AccountRepoMapImpl();
        AccountService service = new AccountServiceImpl(repository);

        System.out.println("Before deposit: " + service.getAccountById(1));
        service.deposit(1, 500);
        System.out.println("After deposit:  " + service.getAccountById(1));
    }
}
