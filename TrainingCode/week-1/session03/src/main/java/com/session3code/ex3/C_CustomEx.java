package com.session3code.ex3;
//min balance is 5000, u can use user define excpetion
/// u have to decide whether u want to create checked or unched ex
class AccountCreationException extends Exception{
	public AccountCreationException(String message) {
		super(message);
	}
}
class NotSufficientFundException extends RuntimeException{
	public NotSufficientFundException(String message) {
		super(message);
	}
}
class Account {
	private int id;
	private double balance;
	public Account(int id, double balance) throws AccountCreationException  {
		this.id = id;
		this.balance = balance;
		if(balance<5000)
			throw new AccountCreationException("min money to create a new account is 5K");
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) throws NotSufficientFundException{
		double temp=balance-amount;
		if (temp < 5000) {
			throw new NotSufficientFundException("You dont have sufficient fund in account !");
		}
		balance=temp;

	}

	public void printDetails() {
		System.out.println("Account ID: " + id);
		System.out.println("Balance: " + balance);
	}
}

public class C_CustomEx {

	public static void main(String[] args) {
		try{
			Account account=new Account(1, 60000);
			account.withdraw(100000);
			account.printDetails();
		}catch(AccountCreationException e){
			System.out.println(e.getMessage());
		}catch (NotSufficientFundException e) {
			System.out.println(e.getMessage());
		}
	}
}
