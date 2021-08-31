package org.hillel;

import daos.ClientDAO;
import dto.ClientDto;
import entities.Client;
import services.ClientService;
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
    public class ClientServiceTest {

        @Mock
        private ClientDAO clientDAO;
        private ClientService clientService;

        @BeforeEach
        public void setUp() {
            clientService = new ClientService(clientDAO);
        }

        @Test
        public void findAllClients() {

            Client client = new Client();
            client.setId(1);
            client.setName("Name");
            client.setEmail("1@ukr.net");
            client.setPhone(380958089097L);
            client.setAbout("client");
            client.setAge(20);

            when(client.findAllClients).thenReturn(Collections.singletonList(client));

            List<ClientDto> actualResult = client.findAllClients();

            assertEquals(1, actualResult.size());
            assertEquals(1, actualResult.get(0).getId());
            assertEquals("Name", actualResult.get(0).getName());
            assertEquals("1@ukr.net", actualResult.get(0).getEmail());
            assertEquals(380958089097L, actualResult.get(0).getPhone());
            assertEquals("client", actualResult.get(0).getAbout());
            assertEquals(20, actualResult.get(0).getAge());
        }
    }

