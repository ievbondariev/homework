package daos;

import entities.Client;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

public class ClientDAO {

    private static final Logger logger = Logger.getLogger(ClientDAO.class);

    public List<Client> findAllClients() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            logger.debug("Connected with database");
            System.out.println("Reading of records from the table");
            logger.debug("Find all clients executed");
            return session.createQuery("from Client").list();
        }
    }

    public void findClientByPhone(long phone) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println(session.createQuery("from Client where phone =" + phone).getResultList());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveClient(Client client) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    public void deleteClient(Client client) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        }
    }

    public void updateClient(Client client) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }
    }

    public void findClientById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println(session.byId(Client.class).getReference(id));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
