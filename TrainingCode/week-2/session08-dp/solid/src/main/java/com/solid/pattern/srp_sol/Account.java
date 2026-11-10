package com.solid.pattern.srp_sol;
//t1 t2 t3
public class Account {

    private String accountNumber;
    private double balance;

    // Business logic
    public void deposit(double amount) {
        balance += amount;
    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}