package daos;

import database.Database;
import entities.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private static final String ACCOUNTS = "SELECT * FROM accounts";
    private static final String INSERT_TO_ACCOUNTS = "INSERT INTO accounts (client_id, number, value) VALUES(?,?,?)";
    private static final String DELETE_FROM_ACCOUNTS = "DELETE from accounts where id=?";
    private static final String UPDATE_ACCOUNTS = "UPDATE accounts set client_id=?, number=?, value=? where id=?";
    private static final String FIND_BY_VALUE = "SELECT number FROM accounts where value>?";

    public List<Account> findAllAccounts() {
        List<Account> resultList = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(ACCOUNTS);
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setClientId(resultSet.getInt("client_id"));
                account.setNumber(resultSet.getString("number"));
                account.setValue(resultSet.getDouble("value"));

                resultList.add(account);
                System.out.println(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public void insert(Account account) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_TO_ACCOUNTS)) {

            statement.setInt(1, account.getClientId());
            statement.setString(2, account.getNumber());
            statement.setDouble(3, account.getValue());
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_FROM_ACCOUNTS)) {
            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void update(Account account) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ACCOUNTS)) {
            statement.setInt(1, account.getClientId());
            statement.setString(2, account.getNumber());
            statement.setDouble(3, account.getValue());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> findByValues(double value) {
        List<String> resultList = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_VALUE);
            statement.setDouble(1, value);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultList.add(resultSet.getString("number"));
                System.out.println(resultSet.getString("number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
