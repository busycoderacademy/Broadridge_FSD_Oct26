package com.bankapp.integration;

import com.bankapp.dto.Account;
import com.bankapp.repo.AccountRepoMapImpl;
import com.bankapp.service.AccountService;
import com.bankapp.service.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Integration of real service + real in-memory repository; no Mockito and no Spring. */
class AccountServiceIntegrationTest {
    private AccountService service;

    @BeforeEach
    void setUp() {
        service = new AccountServiceImpl(new AccountRepoMapImpl());
    }

    @Test
    void depositIsPersistedInRepository() {
        service.deposit(1, 500);
        assertEquals(2_500, service.getAccountById(1).getBalance());
    }

    @Test
    void withdrawIsPersistedInRepository() {
        service.withdraw(2, 700);
        assertEquals(1_300, service.getAccountById(2).getBalance());
    }

    @Test
    void transferUpdatesBothAccounts() {
        service.transfer(1, 2, 600);
        assertEquals(1_400, service.getAccountById(1).getBalance());
        assertEquals(2_600, service.getAccountById(2).getBalance());
    }

    @Test
    void transferPreservesTotalMoney() {
        double before = service.getAllAccounts().stream().mapToDouble(Account::getBalance).sum();
        service.transfer(1, 2, 350);
        double after = service.getAllAccounts().stream().mapToDouble(Account::getBalance).sum();
        assertEquals(before, after, 0.0001);
    }

    @Test
    void completeBankingWorkflowProducesExpectedBalances() {
        service.deposit(1, 1_000);   // Raj: 3,000
        service.withdraw(2, 500);    // Ekta: 1,500
        service.transfer(1, 2, 1_000); // Raj: 2,000; Ekta: 2,500

        assertAll(
            () -> assertEquals(2_000, service.getAccountById(1).getBalance()),
            () -> assertEquals(2_500, service.getAccountById(2).getBalance())
        );
    }

    @Test
    void insufficientWithdrawalDoesNotChangeBalance() {
        assertThrows(IllegalStateException.class, () -> service.withdraw(1, 9_000));
        assertEquals(2_000, service.getAccountById(1).getBalance());
    }

    @Test
    void invalidAccountIsReported() {
        assertThrows(IllegalArgumentException.class, () -> service.deposit(999, 100));
    }

    @Test
    void invalidAmountIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> service.deposit(1, -100));
    }
}
