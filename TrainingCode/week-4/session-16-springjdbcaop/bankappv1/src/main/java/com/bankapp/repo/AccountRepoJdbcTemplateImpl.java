package com.bankapp.repo;

import com.bankapp.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class AccountRepoJdbcTemplateImpl implements  AccountRepo {

   private JdbcTemplate jdbcTemplate;

   @Autowired
    public AccountRepoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getAccountById(int id) {
        return jdbcTemplate.queryForObject("select * from account where id=?", new AccountRowMapper(), id);
    }

    @Override
    public void updateAccount(Account account) {
       jdbcTemplate.update("update account set balance=? where id=?", new Object[]{account.getBalance(),account.getId()});
    }

    @Override
    public List<Account> getAllAccounts() {
       //While using spring jdbc u need to tell spring how to convert a tuple to the Account object?
        //"RowMapper"
        return jdbcTemplate.query("select * from account", new AccountRowMapper());
    }
}
