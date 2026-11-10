package com.bankapp.repo;

import com.bankapp.dto.Account;
import com.bankapp.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepoJdbcImpl implements  AccountRepo {

    private Connection connection;

    public AccountRepoJdbcImpl() {
        this.connection = ConnectionFactory.getConnection();
    }
    @Override
    public List<Account> getAccounts() {
        //hit the database and featch all records and convert into List and return back to the user
        List<Account> accounts = new ArrayList<>();
        try{
            PreparedStatement pstmt=connection.prepareStatement("select * from account");
            ResultSet rs =  pstmt.executeQuery();//give u resultset
            while (rs.next()){
               Account account=new Account(rs.getInt(1),
                       rs.getString(2), rs.getDouble(3));
                accounts.add(account);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account getAccountById(int id) {
        Account account=null;
        try{
            PreparedStatement pstmt=connection.prepareStatement("select * from account where id=?");
            pstmt.setInt(1,id);
            ResultSet rs =  pstmt.executeQuery();//give u resultset
            if (rs.next()){
                 account=new Account(rs.getInt(1),
                        rs.getString(2), rs.getDouble(3));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void update(Account account) {
        try{
            PreparedStatement pstmt=connection.prepareStatement("update account set balance=? where id=?");
            pstmt.setDouble(1, account.getBalance());
            pstmt.setInt(2, account.getId());
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
