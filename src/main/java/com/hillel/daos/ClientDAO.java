package com.hillel.daos;

import com.hillel.entities.Client;
import com.hillel.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class ClientDAO {

    private static final String FIND_ALL_CLIENTS = "SELECT * FROM clients";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<Client> clientRowMapper;

    public List<Client> findAllClients() {
        return jdbcTemplate.query(FIND_ALL_CLIENTS, clientRowMapper);
    }

//    public List<Client> findAllClients() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            logger.debug("Connected with com.hillel.database");
//            System.out.println("Reading of records from the table");
//            logger.debug("Find all clients executed");
//            return session.createQuery("from Client order by id").list();
//        }
//    }

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
