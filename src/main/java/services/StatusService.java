package services;

import daos.HibernateUtil;
import daos.StatusDAO;
import dto.StatusDto;
import entities.Account;
import entities.Status;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StatusService {

    private static final Logger logger = Logger.getLogger(StatusService.class);

    private final StatusDAO statusDAO;

    public StatusService(StatusDAO statusDao) {
        this.statusDAO = statusDao;
        logger.debug("StatusDao configured");
    }

    public List<StatusDto> findAllStatuses() {
        List<Status> statuses = statusDAO.findAllStatuses();
        List<StatusDto> statusDtos = new ArrayList<>();

        for (Status status : statuses) {
            StatusDto statusDto = new StatusDto();
            statusDto.setId(status.getId());
            statusDto.setAlias(status.getAlias());
            statusDto.setDescription(status.getDescription());
            statusDtos.add(statusDto);
        }
        logger.debug("StatusService configured");
        return statusDtos;
    }

    public void saveStatus(Status status) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(status);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteStatus(Status status) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(status);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateStatus(Status status) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(status);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void findStatusById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println(session.createQuery("from Status where id =" + id).getResultList());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

