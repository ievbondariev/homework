package services;

import daos.ClientDAO;
import daos.HibernateUtil;
import dto.ClientDto;
import entities.Client;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private static final Logger logger = Logger.getLogger(ClientService.class);

    private ClientDAO clientDao;

    public ClientService(ClientDAO clientDao) {
        this.clientDao = clientDao;
        logger.debug("ClientDao configured");
    }

    public List<ClientDto> findAllClients() {

        List<Client> clients = clientDao.findAllClients();
        List<ClientDto> clientDtos = new ArrayList<>();

        for (Client client : clients) {
            ClientDto clientDto = new ClientDto();
            clientDto.setId(client.getId());
            clientDto.setName(client.getName());
            clientDto.setEmail(client.getEmail());
            clientDto.setPhone(client.getPhone());
            clientDto.setAbout(client.getAbout());
            clientDto.setAge(client.getAge());

            clientDtos.add(clientDto);
        }
        logger.debug("ClientService started");
        return clientDtos;
    }

    public void saveClient(Client client) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteClient(Client client) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateClient(Client client) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void findClientById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println(session.createQuery("from Client where id =" + id).getResultList());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findClientByPhone(long phone) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println(session.createQuery("from Client where phone =" + phone).getResultList());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

