package com.hillel.services;

import com.hillel.daos.ClientDAO;
import com.hillel.dto.ClientDto;
import com.hillel.entities.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private ClientDAO clientDao;

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

    public void save(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setAbout(clientDto.getAbout());
        client.setAge(clientDto.getAge());

        clientDao.saveClient(client);
    }

    public void setClientDao(ClientDAO clientDao) {
        this.clientDao = clientDao;
    }
}

