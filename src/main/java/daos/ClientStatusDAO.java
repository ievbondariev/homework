package daos;

import database.Database;
import entities.ClientStatus;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientStatusDAO {

    private  static final Logger logger = Logger.getLogger(ClientStatusDAO.class);

    private static final String CLIENT_STATUSES = "SELECT *  FROM client_status";

    public List<ClientStatus> findAllClientStatus() {
        List<ClientStatus> resultList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(CLIENT_STATUSES)) {

            while (resultSet.next()) {
                ClientStatus clientStatus = new ClientStatus();
                clientStatus.setClientId(resultSet.getInt("client_id"));
                clientStatus.setStatusId(resultSet.getInt("status_id"));
                resultList.add(clientStatus);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        logger.debug("Find all clients status executed");
        return resultList;
    }
}