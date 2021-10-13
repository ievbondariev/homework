package com.hillel.daos.mapper;

import com.hillel.entities.Account;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getLong("id"));
        account.setClientId(rs.getInt("client_id"));
        account.setNumber(rs.getString("number"));
        account.setValue(rs.getDouble("value"));
        return account;
    }
}
