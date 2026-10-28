package com.session3code.ex3;

class Account {
	private int id;
	private double balance;

	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("Withdrawal amount must be positive.");
		}
		balance -= amount;

	}

	public void printDetails() {
		System.out.println("Account ID: " + id);
		System.out.println("Balance: " + balance);
	}
}

public class C_CustomEx {

	public static void main(String[] args) {

	}
}
