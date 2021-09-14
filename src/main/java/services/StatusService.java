package services;

import daos.StatusDAO;
import dto.StatusDto;
import entities.Status;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class StatusService {

    private static final Logger logger = Logger.getLogger(StatusService.class);

    private final StatusDAO statusDAO;

    public StatusService() {
        statusDAO = new StatusDAO();
        logger.debug("StatusDao configured");
    }

    public List<StatusDto> findAllStatuses() {
        List<Status> statuses = statusDAO.findAllStatuses();
        List<StatusDto> statusDtos = new ArrayList<>();

        for (Status status : statuses) {
            StatusDto statusDto = new StatusDto();
            statusDto.setId(status.getId());
            statusDto.setAlias(status.getAlias());
            statusDto.setDescription(status.getDescription());
            statusDtos.add(statusDto);
        }
        logger.debug("StatusService configured");
        return statusDtos;
    }
}

