package com.bankapp.repo;

import com.bankapp.dto.Account;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Nullable
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account=new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3));
        return account;
    }
}
