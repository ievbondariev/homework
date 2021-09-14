package database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final Logger logger = Logger.getLogger(Database.class);

    private static final String URL = "jdbc:postgresql://localhost:5432/ievhenbondarew";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.error("No connections with database");
        return null;
    }
}
