package daos;

import entities.Card;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class CardDAO {
    public List<Card> findAllCards() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try (session) {
            System.out.println("Reading of records from the table");
            return session.createQuery("FROM Card order by id", Card.class).list();
        }
    }

    public void saveCard(Card card) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(card);
            transaction.commit();
        }
    }

    public void deleteCard(Card card) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(card);
            transaction.commit();
        }
    }
}
