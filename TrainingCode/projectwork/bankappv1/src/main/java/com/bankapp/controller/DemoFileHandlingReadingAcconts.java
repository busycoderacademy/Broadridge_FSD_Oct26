package com.bankapp.controller;

import com.bankapp.dto.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DemoFileHandlingReadingAcconts {
    public static void main(String[] args) {
        List<Account> accounts=getAllAccounts();
        for(Account account: accounts){
            System.out.println(account);
        }
    }



    private static List<Account> getAllAccounts() {
        List<Account> accounts = new LinkedList<>();
        try {
            BufferedReader br=new BufferedReader(new FileReader(new File("accounts.txt")));
            String line=null;

            while((line=br.readLine())!=null){
                String tokens[]=line.split(":");
                Integer id=Integer.parseInt(tokens[0]);
                String name=tokens[1];
                Double balance=Double.parseDouble(tokens[2]);

                accounts.add(new Account(id,name,balance));
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }catch(IOException e){
            System.out.println("some io exception");
        }

        return accounts;
    }
}
