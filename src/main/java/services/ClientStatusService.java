package services;

import daos.ClientStatusDAO;
import dto.ClientStatusDto;
import entities.ClientStatus;

import java.util.ArrayList;
import java.util.List;

public class ClientStatusService {
    private final ClientStatusDAO clientStatusDao;

    public ClientStatusService() {
        clientStatusDao = new ClientStatusDAO();
    }

    public List<ClientStatusDto> findAllClientStatus() {
        List<ClientStatus> clientStatuses = clientStatusDao.findAllClientStatus();
        List<ClientStatusDto> clientStatusDtos = new ArrayList<>();

        for (ClientStatus clientStatus : clientStatuses) {
            ClientStatusDto clientStatusDto = new ClientStatusDto();
            clientStatusDto.setClientId(clientStatus.getClientId());
            clientStatusDto.setStatusId(clientStatus.getStatusId());
            clientStatusDtos.add(clientStatusDto);
        }
        return clientStatusDtos;
    }
}

