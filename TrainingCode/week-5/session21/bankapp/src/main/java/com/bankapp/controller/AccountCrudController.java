package com.bankapp.controller;

import com.bankapp.converter.AccountConverter;
import com.bankapp.dto.AccountDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class AccountCrudController {

    private AccountService accountService;

    @Autowired
    public AccountCrudController(AccountService accountService) {
        this.accountService = accountService;
    }
    //get all the accounts
    @GetMapping(path = "accounts")
    public List<AccountDto> accounts(){
        return accountService.getAllAccounts().stream()
                .map(AccountConverter::convertToDto).toList();
    }
    //get account by id
    @GetMapping(path = "accounts/{id}")
    public  AccountDto getAccountById(@PathVariable int id){
        return AccountConverter.convertToDto(accountService.getAccountById(id));
    }
}
