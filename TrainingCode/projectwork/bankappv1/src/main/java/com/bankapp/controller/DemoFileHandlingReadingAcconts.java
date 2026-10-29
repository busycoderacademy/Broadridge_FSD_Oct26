package com.bankapp.controller;

import com.bankapp.dto.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DemoFileHandlingReadingAcconts {
    public static void main(String[] args) {
        List<Account> accounts=getAllAccounts();
        for(Account account:accounts){
            System.out.println(account);
        }
    }



    private static List<Account> getAllAccounts() {
        //read the file make token of each file sepeate on behalf of : put them into a arrayList and return the the user
        List<Account> accounts = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("accounts.txt")));
            String line=null;
            while((line=bufferedReader.readLine())!=null){
                String[] tokens = line.split(":");
                // public Account(int id, String name, double balance)
                Account account = new Account(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2]));

                accounts.add(account);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file is not found");
        }catch(IOException e){
            System.out.println("some io exction");
        }
        return accounts;
    }
}
