package org.hillel;

import daos.StatusDAO;
import dto.StatusDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import services.StatusService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StatusServiceTest {

    @ExtendWith(MockitoExtension.class)
    public static class StatusesServiceTest {

        @Mock
        private StatusDAO statusDAO;
        private StatusService statusService;

        @BeforeEach
        public void setup() {
            statusService = new StatusService();
        }

        @Test
        public void findAllStatuses() {

            StatusDto statusDto = new StatusDto();
            statusDto.setId(1);
            statusDto.setAlias("premium");
            statusDto.setDescription("card");

            when(statusService.findAllStatuses()).thenReturn(Collections.singletonList(statusDto));

            List<StatusDto> actualResult = statusService.findAllStatuses();
            assertEquals(1, actualResult.size());
            assertEquals(1, actualResult.get(0).getId());
            assertEquals("premium", actualResult.get(0).getAlias());
            assertEquals("card", actualResult.get(0).getDescription());
        }
    }
}
