import daos.AccountDAO;
import daos.ClientDAO;
import daos.StatusDAO;
import entities.Client;

public class Main {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
//        clientDAO.findAllClients();
        clientDAO.findByPhone(0);

        AccountDAO accountDAO = new AccountDAO();
//        accountDAO.findAllAccounts();
        accountDAO.findByValues();

        clientDAO.joinClient();

//        Client client1 = clientDAO.findById(7);
//        client1.setAge(16);
//        clientDAO.update(client1);
//        System.out.println(client1);

        clientDAO.joinNameEmailAlias();

//        StatusDAO statusDAO = new StatusDAO();
//        statusDAO.findAllStatuses();
    }
}


