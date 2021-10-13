package com.hillel.daos.mapper;

import com.hillel.entities.Client;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ClientMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getLong("id"));
        client.setName(resultSet.getString("name"));
        client.setEmail(resultSet.getString("email"));
        client.setAge(resultSet.getInt("age"));
        client.setPhone(resultSet.getLong("phone"));
        client.setAbout(resultSet.getString("about"));
        return client;
    }

}
