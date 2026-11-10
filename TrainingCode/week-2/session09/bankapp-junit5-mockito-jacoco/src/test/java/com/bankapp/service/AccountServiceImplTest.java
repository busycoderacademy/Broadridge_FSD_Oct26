package com.bankapp.service;

import com.bankapp.dto.Account;
import com.bankapp.repo.AccountRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock AccountRepo accountRepo;

    @InjectMocks AccountServiceImpl service;

    @Test
    void depositsMoneyAndPersistsUpdatedAccount() {
        Account account = new Account(1, "raj", 2_000);
        when(accountRepo.getAccountById(1)).thenReturn(account);

        service.deposit(1, 500);
        assertEquals(2_500, account.getBalance());

        verify(accountRepo).updateAccount(account);
    }

    @Test
    void rejectsZeroOrNegativeDepositBeforeRepositoryAccess() {
        assertThrows(IllegalArgumentException.class, () -> service.deposit(1, 0));
        assertThrows(IllegalArgumentException.class, () -> service.deposit(1, -10));

        verifyNoInteractions(accountRepo);
    }

    @Test
    void rejectsNaNDeposit() {
        assertThrows(IllegalArgumentException.class, () -> service.deposit(1, Double.NaN));
        verifyNoInteractions(accountRepo);
    }

    @Test
    void rejectsDepositWhenAccountDoesNotExist() {
        when(accountRepo.getAccountById(404)).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> service.deposit(404, 100));
        verify(accountRepo, never()).updateAccount(any());
    }

    @Test
    void withdrawsMoneyWhenBalanceIsSufficient() {
        Account account = new Account(1, "raj", 2_000);
        when(accountRepo.getAccountById(1)).thenReturn(account);
        service.withdraw(1, 500);
        assertEquals(1_500, account.getBalance());
        verify(accountRepo).updateAccount(account);
    }

    @Test
    void rejectsWithdrawalWhenBalanceIsInsufficient() {
        Account account = new Account(1, "raj", 200);
        when(accountRepo.getAccountById(1)).thenReturn(account);
        assertThrows(IllegalStateException.class, () -> service.withdraw(1, 500));
        assertEquals(200, account.getBalance());
        verify(accountRepo, never()).updateAccount(any());
    }

    @Test
    void rejectsWithdrawalOfNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> service.withdraw(1, -1));
        verifyNoInteractions(accountRepo);
    }

    @Test
    void transfersMoneyAndUpdatesBothAccounts() {
        Account from = new Account(1, "raj", 2_000);
        Account to = new Account(2, "ekta", 1_000);
        when(accountRepo.getAccountById(1)).thenReturn(from);
        when(accountRepo.getAccountById(2)).thenReturn(to);

        service.transfer(1, 2, 500);

        assertEquals(1_500, from.getBalance());
        assertEquals(1_500, to.getBalance());
        InOrder order = inOrder(accountRepo);
        order.verify(accountRepo).getAccountById(1);
        order.verify(accountRepo).getAccountById(2);
        order.verify(accountRepo).updateAccount(from);
        order.verify(accountRepo).updateAccount(to);
    }

    @Test
    void rejectsTransferToSameAccount() {
        assertThrows(IllegalArgumentException.class, () -> service.transfer(1, 1, 100));
        verifyNoInteractions(accountRepo);
    }

    @Test
    void rejectsTransferWhenSourceHasInsufficientBalance() {
        Account from = new Account(1, "raj", 100);
        Account to = new Account(2, "ekta", 500);
        when(accountRepo.getAccountById(1)).thenReturn(from);
        when(accountRepo.getAccountById(2)).thenReturn(to);

        assertThrows(IllegalStateException.class, () -> service.transfer(1, 2, 200));
        assertEquals(100, from.getBalance());
        assertEquals(500, to.getBalance());
        verify(accountRepo, never()).updateAccount(any());
    }

    @Test
    void rejectsTransferWhenDestinationDoesNotExistWithoutChangingSource() {
        Account from = new Account(1, "raj", 2_000);
        when(accountRepo.getAccountById(1)).thenReturn(from);
        when(accountRepo.getAccountById(2)).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> service.transfer(1, 2, 500));
        assertEquals(2_000, from.getBalance());
        verify(accountRepo, never()).updateAccount(any());
    }

    @Test
    void returnsAccountById() {
        Account account = new Account(1, "raj", 2_000);
        when(accountRepo.getAccountById(1)).thenReturn(account);
        assertSame(account, service.getAccountById(1));
        verify(accountRepo).getAccountById(1);
    }

    @Test
    void throwsWhenRequestedAccountDoesNotExist() {
        when(accountRepo.getAccountById(999)).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> service.getAccountById(999));
    }

    @Test
    void returnsAllAccounts() {
        List<Account> expected = List.of(new Account(1, "raj", 2_000));
        when(accountRepo.getAllAccounts()).thenReturn(expected);
        assertEquals(expected, service.getAllAccounts());
        verify(accountRepo).getAllAccounts();
    }
}
