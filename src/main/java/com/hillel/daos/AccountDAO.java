package com.hillel.daos;

import com.hillel.entities.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hillel.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AccountDAO {
    private static final String FIND_ALL_ACCOUNTS = "SELECT * FROM accounts";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<Account> accountRowMapper;

    public List<Account> findAllAccounts() {
        return jdbcTemplate.query(FIND_ALL_ACCOUNTS, accountRowMapper);
    }

//    public List<Account> findAllAccounts() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            System.out.println("Reading of records from the table");
//            return session.createQuery("from Account").list();
//        }
//    }

    public void save(Account account) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        }
    }

    public void delete(Account account) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(account);
            transaction.commit();
        }
    }

    public void update(Account account) {
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
