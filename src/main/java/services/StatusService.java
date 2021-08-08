package services;

import daos.StatusDAO;
import dto.StatusDto;
import entities.Status;

import java.util.ArrayList;
import java.util.List;

public class StatusService {
    private final StatusDAO statusDao;

    public StatusService() {
        statusDao = new StatusDAO();
    }

    public List<StatusDto> findAllStatuses() {
        List<Status> statuses = statusDao.findAllStatuses();
        List<StatusDto> statusDtos = new ArrayList<>();

        for (Status status : statuses) {
            StatusDto statusDto = new StatusDto();
            statusDto.setId(status.getId());
            statusDto.setAlias(status.getAlias());
            statusDto.setDescription(status.getDescription());
            statusDtos.add(statusDto);
        }
        return statusDtos;
    }
}

