package com.bankapp.converter;

import com.bankapp.dto.AccountDto;
import com.bankapp.entities.Account;

public class AccountConverter {
    // Account to AccountDto
    public static AccountDto convertToDto(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .balance(account.getBalance())
                .build();
    }

    // AccountDto to Account
    public static Account convertToAccount(AccountDto accountDto) {
        return Account.builder()
                .id(accountDto.getId())
                .name(accountDto.getName())
                .balance(accountDto.getBalance())
                .build();
    }
}
