package com.bankapp.proxy;

import com.bankapp.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
//Declartive rest client
@FeignClient(name = "account-service", url = "http://localhost:8090/bankapp/api/")
public interface AccountFeignClientService {
    @GetMapping(path = "accounts")
    public List<AccountDto> accounts();
  
    @GetMapping(path = "accounts/{id}")
    public  AccountDto getAccountById(@PathVariable int id);
}