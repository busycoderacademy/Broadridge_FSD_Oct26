package com.bankapp.repo;

import com.bankapp.dto.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AccountRepoMapImplTest {
    private AccountRepoMapImpl repository;

    @BeforeEach
    void setUp() {
        repository = new AccountRepoMapImpl();
    }

    @Test
    void returnsAccountForExistingId() {
        Account account = repository.getAccountById(1);
        assertNotNull(account);
        assertEquals("raj", account.getName());
        assertEquals(2_000, account.getBalance());
    }

    @Test
    void returnsNullForUnknownId() {
        assertNull(repository.getAccountById(999));
    }

    @Test
    void updatesAccount() {
        Account account = repository.getAccountById(1);
        account.setBalance(4_500);
        repository.updateAccount(account);
        assertEquals(4_500, repository.getAccountById(1).getBalance());
    }

    @Test
    void returnsAllAccounts() {
        List<Account> accounts = repository.getAllAccounts();
        assertEquals(2, accounts.size());
    }

    @Test
    void returnedListIsIndependentFromRepositoryCollection() {
        List<Account> accounts = repository.getAllAccounts();
        accounts.clear();
        assertEquals(2, repository.getAllAccounts().size());
    }
}
