package com.bankapp.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "acc_table")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false, name = "acc_holder_name")
    private String name;
    private double balance;

    public  Account() {}
    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
