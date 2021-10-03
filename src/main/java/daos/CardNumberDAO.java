package daos;

import entities.CardNumber;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class CardNumberDAO {
    public List<CardNumber> findAllCardNumbers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try (session) {
            System.out.println("Reading of records from the table");
            return session.createQuery("FROM CardNumber").getResultList();
        }
    }

    public void save(CardNumber cardNumber) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(cardNumber);
            transaction.commit();
        }
    }
}
