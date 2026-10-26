package com.session01;
/*
• Create the Maven project and a console-based banking workspace.
• Implement Account with accountNumber, accountHolderName and balance; add a main method to create and display sample accounts.
• Keep fields private and use clear naming.
 */
class Account{
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double balance){
        this.accountNumber=accountNumber;//we are assigning local variable to itself
        this.accountHolderName=accountHolderName;
        this.balance=balance;
    }
    public void displayAccountDetails(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}
public class BankApp {
    public static void main(String[] args) {
        Account account=new Account("123456789", "John Doe", 1000.0);
        account.displayAccountDetails();
    }
}
