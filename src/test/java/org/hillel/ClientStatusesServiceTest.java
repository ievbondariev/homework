package org.hillel;


import com.hillel.daos.ClientStatusDAO;
import com.hillel.dto.ClientStatusDto;
import com.hillel.entities.ClientStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.hillel.services.ClientStatusService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ClientStatusesServiceTest {

    @ExtendWith(MockitoExtension.class)
    public static class ClientStatusServiceTest {

        @Mock
        private ClientStatusDAO clientStatusDao;

        private ClientStatusService clientStatusService;

        @BeforeEach
        public void setup() {
            clientStatusService = new ClientStatusService(clientStatusDao);
        }

        @Test
        public void findAllClientStatuses() {

            ClientStatus clientStatus = new ClientStatus();
            clientStatus.setClientId(1);
            clientStatus.setStatusId(1);

            when(clientStatusDao.findAllClientStatus()).thenReturn(Collections.singletonList(clientStatus));

            List<ClientStatusDto> actualResult = clientStatusService.findAllClientStatus();
            assertEquals(1, actualResult.size());
            assertEquals(1, actualResult.get(0).getClientId());
            assertEquals(1, actualResult.get(0).getStatusId());
        }
    }
}

