package com.session05.topic.object_class;

import java.util.Objects;

class Account implements Cloneable{
    private int id;
    private String name;
    private double balance;

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    //u can override method
    @Override
    public String toString(){
        return "id : "+ id +" name: "+ name+" balance: "+balance;
    }
    //i need to override equal method ==> good programming practice GPP u should also override===> hashcode() method

    ///this method i am calling  if(account1.equals(account2))
    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()) return false;
        Account account = (Account) object;
        return id == account.id && Double.compare(balance, account.balance) == 0 && Objects.equals(name, account.name);
    }
//
//    //?
    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class DemoObjectClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        //Typecasing
        Account account1=new Account(121,"raj",4000);
        Account accountClone=(Account)account1.clone();
        System.out.println(account1);
        System.out.println(accountClone);


       // Account account2=new Account(121,"raj",4000);

        //Why u should override equals() method with hashcode() method
        //if 2 objects are equal then their hashcode should also be equal
        //if 2 objects have equal hashcode then they may not be same

//        if(account1.equals(account2)){
//            System.out.println("are same");
//        }else{
//            System.out.println("are not same");
//        }
//        System.out.println(account1.hashCode());
//        System.out.println(account2.hashCode());

//        System.out.println(account);


    }
}
