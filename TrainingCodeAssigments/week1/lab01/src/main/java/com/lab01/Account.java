package com.lab01;

public class Account {
    private int id;
    private  String name;
    private double balance;

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public Account(int id, String name){
        this.id = id;
        this.name = name;
    }
    //get id
    public int getId(){
        return  this.id;
    }
    public String getName(){
        return this.name;
    }
    public  double getBalance(){
        return this.balance;
    }
    public void credit(double amount){
        this.balance+=amount;
    }
    public void debit(double amount){
        if(amount>balance){
            System.out.println("debit is not possible");
        }else {
            this.balance -= amount;
        }
    }
    void transferTo(Account anotherAccount, double amount){
        if(balance >= amount){
            anotherAccount.credit(amount);
        }else{
            System.out.println("transfer is not possible");
        }
    }
    public void printAccountDetals(){
        System.out.println("id:"+this.id+" name:"+this.name+" balance:"+this.balance);
    }
}
