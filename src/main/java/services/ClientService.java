package services;

import daos.ClientDAO;
import dto.ClientDto;
import entities.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private final ClientDAO clientDao;

    public ClientService() {
        clientDao = new ClientDAO();
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
        return clientDtos;
    }
}

