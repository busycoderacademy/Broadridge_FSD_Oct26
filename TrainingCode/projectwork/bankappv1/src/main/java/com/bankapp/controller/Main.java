package com.bankapp.controller;

import com.bankapp.repo.AccountRepoFileImpl;
import com.bankapp.service.*;

public class Main {
    public static void main(String[] args) {
        //i have to do it manaully take the objet of repo and put inside service layer
        //i dont want this can somebody can do on behalf of me
        //YES ie done by "spring framewrok"
        AccountService accountService = new AccountServiceImpl(new AccountRepoFileImpl(), new SmsNotificationService());
        System.out.println(accountService.getAccountById(1));

    }
}
