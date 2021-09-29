import daos.*;
import entities.*;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        ClientDAO clientDAO = new ClientDAO();

//        clientDAO.findClientById(6);
//        clientDAO.findClientByPhone(380958089097L);

        Client client = new Client();
        client.setId(11);
        client.setName("Ik");
        client.setEmail("uuu@ukr.net");
        client.setAge(21);
        client.setAbout("new");
        clientDAO.saveClient(client);
        client.setId(11);
        clientDAO.deleteClient(client);
        clientDAO.findAllClients().forEach(System.out::println);

        AccountDAO accountDAO = new AccountDAO();
        Account account = new Account();
        accountDAO.findAllAccounts().forEach(System.out::println);
        accountDAO.findAccountById(5);

        StatusDAO statusDAO = new StatusDAO();
        Status status = new Status();
        status.setId(3);
        status.setAlias("BUSINESS");
        status.setDescription("MASTERCARD PLATINUM");
        statusDAO.updateStatus(status);
//        statusDAO.findStatusById(3);

        CardDAO cardDAO = new CardDAO();
        Card card = new Card();
        card.setId(9);
        card.setName("MasterCard");
        card.setType("Credit");
//        cardDAO.saveCard(card);
        card.setClient(client);
//        cardDAO.findAllCards().forEach(System.out::println);
//        clientDAO.findAllClients().forEach(System.out::println);

        CardNumberDAO cardNumberDAO = new CardNumberDAO();
        CardNumber cardNumber = new CardNumber();
//        account.setCardNumber(cardNumber);
        cardNumberDAO.findAllCardNumbers().forEach(System.out::println);

        logger.info("MainClass works");
    }
}