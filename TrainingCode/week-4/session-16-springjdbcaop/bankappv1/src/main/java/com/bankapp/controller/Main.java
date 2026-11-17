package com.bankapp.controller;

import com.bankapp.config.AppConfig;
import com.bankapp.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {
        //i have to do it manaully take the objet of repo and put inside service layer
        //i dont want this can somebody can do on behalf of me
        //YES ie done by "spring framewrok"
//        AccountService accountService = new AccountServiceImpl(new AccountRepoMapImpl());
//        System.out.println(accountService.getAccountById(1));

//        ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        AbstractApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.registerShutdownHook();
        AccountService accountService
                =ctx.getBean("accountService", AccountService.class);
//        System.out.println( accountService.getAccountById(1));
        accountService.transfer(2,1,10);


    }
}
