package com.bankapp.service;

import com.bankapp.dto.AccountDto;
import com.bankapp.dto.TxDto;
import com.bankapp.proxy.AccountFeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TxService {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private AccountFeignClientService accountFeignClientService;

    public List<TxDto> getAllTxForAnAccountId(int id){

//        AccountDto accountDto = restTemplate
//                .getForObject("http://localhost:8090/bankapp/api/accounts/"+id, AccountDto.class);

        System.out.println("--------------------------------------");
        System.out.println(accountFeignClientService.getAccountById(id));
        System.out.println("--------------------------------------");
        return List.of
                (new TxDto(1,2300, "Transfer", LocalDateTime.now()),
                        new TxDto(3,7300, "Deposit", LocalDateTime.now()),
                        new TxDto(66,4300, "Transfer", LocalDateTime.now()));
    }
}
