package com.bankapp.controller;

import com.bankapp.config.AppConfig;
import com.bankapp.exceptions.BarEx;
import com.bankapp.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws BarEx {
        //i have to do it manaully take the objet of repo and put inside service layer
        //i dont want this can somebody can do on behalf of me
        //YES ie done by "spring framewrok"
//        AccountService accountService =
//                new AccountServiceImpl(new AccountRepoFileImpl());
//        System.out.println(accountService.getAccountById(1));

        ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        AccountService accountService= (AccountService)
                ctx.getBean("accountService");

        accountService.transfer(1,2,10);

    }
}
