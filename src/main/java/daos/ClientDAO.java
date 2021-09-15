package daos;

import database.Database;
import entities.Account;
import entities.Client;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;

public class ClientDAO {

    private  static final Logger logger = Logger.getLogger(ClientDAO.class);

    private static final String CLIENTS = "SELECT * FROM clients order by id";
    private static final String INSERT_TO_CLIENTS = "INSERT INTO clients (name, email, phone, about) VALUES(?,?,?,?)";
    private static final String DELETE_FROM_CLIENTS = "DELETE from clients where id=?";
    private static final String UPDATE_CLIENTS = "UPDATE clients set name=?, email=?, phone=?, about=?, age=? where id=?";
    private static final String FIND_BY_PHONE = "SELECT * FROM clients where phone=?";
    private static final String FIND_BY_ID = "SELECT * FROM clients where id=? ";
    private static final String INNER_JOIN_CLIENTS = "select * from clients INNER JOIN accounts ON clients.id = accounts.client_id";


    public List<Client> joinClient() {
        List<Client> resultList = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(INNER_JOIN_CLIENTS);
            logger.debug("Connected with database");
            while (resultSet.next()) {
                Client client = new Client();
                Account account = new Account();
                client.setId(account.getId());
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));
                resultList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.debug("Join client executed");
        return resultList;
    }

    public Client findByPhone(long phone) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_PHONE)) {
            logger.debug("Connected with database");
            statement.setLong(1, phone);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));
                System.out.println(client);
                logger.debug("Find by phone executed");
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Client> findAllClients() {
        List<Client> resultList = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(CLIENTS);
            logger.debug("Connected with database");
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));

                resultList.add(client);
                System.out.println(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.debug("Find all clients executed");
        return resultList;
    }

    public void insert(Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_TO_CLIENTS)) {
            logger.debug("Connected with database");

            statement.setString(1, client.getName());
            statement.setString(2, client.getEmail());
            statement.setLong(3, client.getPhone());
            statement.setString(4, client.getAbout());
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        logger.debug("Insert client executed");
    }

    public void delete(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_FROM_CLIENTS)) {
            logger.debug("Connected with database");
            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        logger.debug("Delete client executed");
    }

    public void update(Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENTS)) {
            logger.debug("Connected with database");
            statement.setString(1, client.getName());
            statement.setString(2, client.getEmail());
            statement.setLong(3, client.getPhone());
            statement.setString(4, client.getAbout());
            statement.setInt(5, client.getAge());
            statement.setInt(6, client.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.debug("Update client executed");
    }

    public Client findById(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            logger.debug("Connected with database");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));
                System.out.println(client);
                logger.debug("Find client by id executed");
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
