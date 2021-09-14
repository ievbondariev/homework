package services;

import daos.ClientStatusDAO;
import dto.ClientStatusDto;
import entities.ClientStatus;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class ClientStatusService {

    private static final Logger logger = Logger.getLogger(ClientStatusService.class);

    private ClientStatusDAO clientStatusDAO;

    public ClientStatusService(ClientStatusDAO clientStatusDAO) {
        this.clientStatusDAO = clientStatusDAO;
        logger.debug("ClientStatusDao configured");
    }

    public ClientStatusService() {

    }

    public List<ClientStatusDto> findAllClientStatus() {
        List<ClientStatus> clientStatuses = clientStatusDAO.findAllClientStatus();
        List<ClientStatusDto> clientStatusDtos = new ArrayList<>();

        for (ClientStatus clientStatus : clientStatuses) {
            ClientStatusDto clientStatusDto = new ClientStatusDto();
            clientStatusDto.setClientId(clientStatus.getClientId());
            clientStatusDto.setStatusId(clientStatus.getStatusId());
            clientStatusDtos.add(clientStatusDto);
        }
        logger.debug("ClientStatusService started");
        return clientStatusDtos;
    }
}

