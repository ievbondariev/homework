import daos.AccountDAO;
import daos.ClientDAO;
import daos.ClientStatusDAO;
import daos.StatusDAO;
import entities.Client;

public class Main {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
////        clientDAO.findAllClients();
        clientDAO.findByPhone(380958089097L);
//
        AccountDAO accountDAO = new AccountDAO();
////        accountDAO.findAllAccounts();
        accountDAO.findByValues(100000);
//
        clientDAO.joinClient();

    }
}


