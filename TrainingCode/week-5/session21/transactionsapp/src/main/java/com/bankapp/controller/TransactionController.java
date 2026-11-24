package com.bankapp.controller;

import com.bankapp.dto.TxDto;
import com.bankapp.service.TxService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
public class TransactionController {

    @Autowired
    private TxService txService;

    //get all the tx info of account holder 1
    @GetMapping(path = "tx/{accountId}")
    public List<TxDto> getAllTransaction(@PathVariable int accountId){
        return txService.getAllTxForAnAccountId(accountId);
    }
}
