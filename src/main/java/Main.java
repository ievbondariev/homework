import daos.AccountDAO;
import daos.ClientDAO;
import daos.StatusDAO;
import entities.Client;
import entities.Status;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        ClientDAO clientDAO = new ClientDAO();

        clientDAO.findClientById(6);
        clientDAO.findClientByPhone(380958089097L);

        Client client = new Client();
        client.setId(11);
        client.setName("Ik");
        client.setEmail("uuu@ukr.net");
        client.setAge(21);
        client.setAbout("new");
        clientDAO.saveClient(client);
        client.setId(11);
        clientDAO.deleteClient(client);
//        clientDAO.findAllClients().forEach(System.out::println);

        AccountDAO accountDAO = new AccountDAO();
//        accountDAO.findAllAccounts().forEach(System.out::println);
        accountDAO.findAccountById(5);

        StatusDAO statusDAO = new StatusDAO();
        Status status = new Status();
        status.setId(3);
        status.setAlias("BUSINESS");
        status.setDescription("MASTERCARD PLATINUM");
        statusDAO.updateStatus(status);
        statusDAO.findStatusById(3);

        logger.info("MainClass works");
    }
}