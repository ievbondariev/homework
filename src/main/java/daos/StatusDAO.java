package daos;

import database.Database;
import entities.Status;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO {

    private static final Logger logger = Logger.getLogger(StatusDAO.class);

    private static final String STATUSES = "SELECT * FROM statuses";
    private static final String INSERT_TO_STATUSES = "INSERT INTO statuses (alias, description) VALUES(?,?)";
    private static final String DELETE_FROM_STATUSES = "DELETE from statuses where id=?";
    private static final String UPDATE_STATUSES = "UPDATE statuses set alias=?, description=?, where id=?";

    public List<Status> findAllStatuses() {
        List<Status> resultList = new ArrayList<>();

        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(STATUSES);
            logger.debug("Connected with database");
            while (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setAlias(resultSet.getString("alias"));
                status.setDescription(resultSet.getString("description"));

                resultList.add(status);
                System.out.println(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.debug("Find all statuses executed");
        return resultList;
    }

    public void insert(Status status) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_TO_STATUSES)) {
            logger.debug("Connected with database");

            statement.setString(1, status.getAlias());
            statement.setString(2, status.getDescription());
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        logger.debug("Insert status executed");
    }

    public void delete(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_FROM_STATUSES)) {
            logger.debug("Connected with database");
            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        logger.debug("Delete status executed");
    }

    public void update(Status status) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STATUSES)) {
            logger.debug("Connected with database");
            statement.setString(1, status.getAlias());
            statement.setString(2, status.getDescription());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.debug("Update status executed");
    }
}
