package org.hillel;

import com.hillel.daos.ClientDAO;
import com.hillel.dto.ClientDto;
import com.hillel.entities.Client;
import com.hillel.services.ClientService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ClientsServiceTest {

    @ExtendWith(MockitoExtension.class)
    public static class ClientServiceTest {

        @Mock
        private ClientDAO clientDao;
        private ClientService clientService;

        @BeforeEach
        public void setUp() {
            clientService = new ClientService();
        }

        @Test
        public void findAllClients() {

            Client client = new Client();
            client.setId(1L);
            client.setName("Name");
            client.setEmail("1@ukr.net");
            client.setPhone(380958089097L);
            client.setAbout("client");
            client.setAge(20);

            when(clientDao.findAllClients()).thenReturn(Collections.singletonList(client));

            List<ClientDto> actualResult = clientService.findAllClients();

            assertEquals(1, actualResult.size());
            assertEquals(1, actualResult.get(0).getId());
            assertEquals("Name", actualResult.get(0).getName());
            assertEquals("1@ukr.net", actualResult.get(0).getEmail());
            assertEquals(380958089097L, actualResult.get(0).getPhone());
            assertEquals("client", actualResult.get(0).getAbout());
            assertEquals(20, actualResult.get(0).getAge());
        }
    }
}

