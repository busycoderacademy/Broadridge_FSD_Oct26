package com.solid.pattern.srp;

public class Tester {
    public static void main(String[] args) {
        Account account = new Account("121",5000.00);

        account.deposit(1000);
        account.log("Deposit of 1000");
        account.generateReport();
    }
}
