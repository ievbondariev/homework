package org.hillel;

import daos.ClientStatusDAO;
import dto.ClientStatusDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import services.ClientStatusService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ClientStatusesServiceTest {

    @ExtendWith(MockitoExtension.class)
    public class ClientStatusServiceTest {

        @Mock
        private ClientStatusService clientStatusService;
        private ClientStatusDAO clientStatusDAO;

        public ClientStatusServiceTest(ClientStatusDAO clientStatusDAO) {
            this.clientStatusDAO = clientStatusDAO;
        }

        @BeforeEach
        public void setup() {
            clientStatusService = new ClientStatusService(clientStatusDAO);
        }

        @Test
        public void findAllClientStatuses() {

            ClientStatusDto clientStatusDto = new ClientStatusDto();
            clientStatusDto.setClientId(1);
            clientStatusDto.setStatusId(1);

            when(clientStatusService.findAllClientStatus()).thenReturn(Collections.singletonList(clientStatusDto));

            List<ClientStatusDto> actualResult = clientStatusService.findAllClientStatus();
            assertEquals(1, actualResult.size());
            assertEquals(1, actualResult.get(0).getClientId());
            assertEquals(1, actualResult.get(0).getStatusId());
        }
    }
}
