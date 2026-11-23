package com.bankapp.controller;

import com.bankapp.dto.Account;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "v1/api")
public class AccountCrudController {

    private AccountService accountService;

    @Autowired
    public AccountCrudController(AccountService accountService) {
        this.accountService = accountService;
    }
    //get all the accounts
    @GetMapping(path = "accounts")
    public List<Account> accounts(){
        return accountService.getAllAccounts();
    }
    //get account by id
    @GetMapping(path = "accounts/{id}")
    public  Account getAccountById(@PathVariable int id){
        return accountService.getAccountById(id);
    }
}
