package com.bankapp.controller;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransactionType;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;
import com.bankapp.service.transactionstrategy.TransactionStrategy;
import com.bankapp.service.transactionstrategy.TransactionStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/api")
public class AccountTxController {

    private AccountService accountService;

    public AccountTxController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Deposit

   //withdraw

   //transfer
    @PostMapping(path = "transaction/transfer")
    public String transfer(@RequestBody TransferDto transferDto){
        accountService.transfer(transferDto.getFromAccountId(),
                transferDto.getToAccountId(), transferDto.getAmount(),
                transferDto.getTxType());
        TransactionType transactionType=transferDto.getTxType();
        return "moneny is transfered";
    }

    @PostMapping(path = "transaction/deposit")
    public String deposit(@RequestBody DepositDto depositDto){
        accountService.deposit(depositDto.getAccountId(), depositDto.getAmount());
        return "deposit is done";
    }

    @PostMapping(path = "transaction/withdraw")
    public String withdraw(@RequestBody WithdrawDto withdrawDto){
        accountService.withdraw(withdrawDto.getAccountId(), withdrawDto.getAmount());
        return "moneny is withdraw";
    }
}
