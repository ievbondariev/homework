package daos;

import entities.Status;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StatusDAO {

    private static final Logger logger = Logger.getLogger(StatusDAO.class);

    public List<Status> findAllStatuses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            logger.debug("Connected with database");
            System.out.println("Reading of records from the table");
            logger.debug("Find all statuses executed");
            return session.createQuery("from Status").list();
        }
    }

    public void saveStatus(Status status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(status);
            transaction.commit();
        }
    }

    public void deleteStatus(Status status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(status);
            transaction.commit();
        }
    }

    public void updateStatus(Status status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(status);
            transaction.commit();
        }
    }

    public void findStatusById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println(session.byId(Status.class).getReference(id));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
