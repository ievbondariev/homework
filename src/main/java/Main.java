import daos.AccountDAO;
import daos.ClientDAO;
import daos.StatusDAO;
import entities.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
//        clientDAO.findAllClients();
        clientDAO.findByPhone(0);

        AccountDAO accountDAO = new AccountDAO();
//        accountDAO.findAllAccounts();
        accountDAO.findByValues();

        clientDAO.joinClient();

        Client client1 = clientDAO.findById(0);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter new clients age:");
//        client1.setAge(scanner.nextInt());
//        clientDAO.update(client1);
//        System.out.println(client1);

        clientDAO.joinNameEmailAlias();

//        StatusDAO statusDAO = new StatusDAO();
//        statusDAO.findAllStatuses();
    }
}


