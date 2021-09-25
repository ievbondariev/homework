import daos.AccountDAO;
import daos.ClientDAO;
import daos.StatusDAO;
import entities.Client;
import entities.Status;
import org.apache.log4j.Logger;
import services.AccountService;
import services.ClientService;
import services.StatusService;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        ClientDAO clientDAO = new ClientDAO();
//        clientDAO.findByPhone(380958089097L);
//        clientDAO.joinClient();

        ClientService clientService = new ClientService(clientDAO);
        clientService.findClientById(6);
        clientService.findClientByPhone(380958089097L);

        Client client = new Client();
        client.setId(11);
        client.setName("Ik");
        client.setEmail("uuu@ukr.net");
        client.setAge(21);
        client.setAbout("new");
        clientService.saveClient(client);
        client.setId(11);
        clientService.deleteClient(client);
//        clientDAO.findAllClients();

        AccountDAO accountDAO = new AccountDAO();
//        accountDAO.findAllAccounts();
//        accountDAO.findByValues(100000);
        AccountService accountService = new AccountService(accountDAO);
        accountService.findAccountById(5);

        StatusDAO statusDAO = new StatusDAO();
        StatusService statusService = new StatusService(statusDAO);
        Status status = new Status();
        status.setId(3);
        status.setAlias("BUSINESS");
        status.setDescription("MASTERCARD PLATINUM");
        statusService.updateStatus(status);
        statusService.findStatusById(3);

        logger.info("MainClass works");
    }
}