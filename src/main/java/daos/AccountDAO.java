package daos;

import entities.Account;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccountDAO {

    private static final Logger logger = Logger.getLogger(AccountDAO.class);

    public List<Account> findAllAccounts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            logger.debug("Connected with database");
            System.out.println("Reading of records from the table");
            logger.debug("Find all accounts executed");
            return session.createQuery("from Account").list();
        }
    }

    public void saveAccount(Account account) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        }
    }

    public void deleteAccount(Account account) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(account);
            transaction.commit();
        }
    }

    public void updateAccount(Account account) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(account);
            transaction.commit();
        }
    }

    public void findAccountById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println(session.byId(Account.class).getReference(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
