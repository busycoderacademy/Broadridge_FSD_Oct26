package com.solid.pattern.srp;
//t1 t2 t3
public class Account {

    private String accountNumber;
    private double balance;

    // Business logic
    public void deposit(double amount) {
        balance += amount;
    }

    // Logging logic
    public void log(String message) {
        System.out.println("Log: " + message);
    }

    // Reporting logic
    public void generateReport() {
        System.out.println("Account Report: " + accountNumber + " " + balance);
    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}