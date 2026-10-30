package com.session3code.ex5.demo1;

class Account {
    int id;
    double balance;
    static String branchName = "SBI Delhi";
    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Balance: " + balance);
        System.out.println("Branch: " + branchName);
    }
}
public class DemoSer {
    public static void main(String[] args) {

    }
}
