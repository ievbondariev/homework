package com.hillel.services;

import com.hillel.daos.ClientStatusDAO;
import com.hillel.dto.ClientStatusDto;
import com.hillel.entities.ClientStatus;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class ClientStatusService {

//    private static final Logger logger = Logger.getLogger(ClientStatusService.class);

    private ClientStatusDAO clientStatusDao;

    public ClientStatusService(ClientStatusDAO clientStatusDao) {
        this.clientStatusDao = clientStatusDao;
//        logger.debug("ClientStatusDao configured");
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
//        logger.debug("ClientStatusService started");
        return clientStatusDtos;
    }
}

