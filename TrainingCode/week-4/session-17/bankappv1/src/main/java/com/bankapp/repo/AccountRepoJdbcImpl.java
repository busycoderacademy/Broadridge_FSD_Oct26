package com.bankapp.repo;

import com.bankapp.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
//@Profile("test")
public class AccountRepoJdbcImpl implements  AccountRepo {

    private DataSource dataSource;

    @Autowired
    public AccountRepoJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Account getAccountById(int id) {
        Account account=null;
        Connection connection=null;
        try{
             connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement("select * from account where id=?");
            pstmt.setInt(1,id);
            ResultSet rs =  pstmt.executeQuery();//give u resultset
            if (rs.next()){
                account=new Account(rs.getInt(1),
                        rs.getString(2), rs.getDouble(3));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {

        }
        return account;
    }

    @Override
    public void updateAccount(Account account) {
        //Spring JDBC
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement("update account set balance=? where id=?");
            pstmt.setDouble(1, account.getBalance());
            pstmt.setInt(2, account.getId());
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //close the con
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        //hit the database and featch all records and convert into List and return back to the user
        List<Account> accounts = new ArrayList<>();
        try{
            Connection connection=dataSource.getConnection();
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
}
