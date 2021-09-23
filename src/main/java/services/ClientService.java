package services;

import daos.ClientDAO;
import dto.ClientDto;
import entities.Client;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private static final Logger logger = Logger.getLogger(ClientService.class);

    private  ClientDAO clientDao;

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
}

