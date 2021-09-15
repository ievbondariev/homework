import daos.AccountDAO;
import daos.ClientDAO;
import daos.ClientStatusDAO;
import daos.StatusDAO;
import entities.Client;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import servlets.ClientServlet;

public class Main {
    private  static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {

        ClientDAO clientDAO = new ClientDAO();
        clientDAO.findAllClients();
        clientDAO.findByPhone(380958089097L);
//
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.findAllAccounts();
        accountDAO.findByValues(100000);
//
        clientDAO.joinClient();

        logger.info("MainClass works");
    }
}