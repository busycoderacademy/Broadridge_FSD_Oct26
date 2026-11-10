package com.bankapp.repo;

import com.bankapp.dto.Account;
import java.util.List;

public interface AccountRepo {
    Account getAccountById(int id);
    void updateAccount(Account account);
    List<Account> getAllAccounts();
}
