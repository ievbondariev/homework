package org.hillel;

import daos.AccountDAO;
import dto.AccountDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import services.AccountService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AccountsServiceTest {

    @ExtendWith(MockitoExtension.class)
    public static class AccountServiceTest {

        @Mock
        private AccountDAO accountDAO;
        private AccountService accountService;

        @BeforeEach
        public void setUp() {
            accountService = new AccountService(accountDAO);
        }

        @Test
        public void findAllAccounts() {

            AccountDto accountDto = new AccountDto();
            accountDto.setId(1);
            accountDto.setClientId(1);
            accountDto.setNumber("UA2625");
            accountDto.setValue(5000);

            when(accountService.findAllAccounts()).thenReturn(Collections.singletonList(accountDto));

            List<AccountDto> actualResult = accountService.findAllAccounts();

            assertEquals(1, actualResult.size());
            assertEquals(1, actualResult.get(0).getId());
            assertEquals(1, actualResult.get(0).getClientId());
            assertEquals("UA2625", actualResult.get(0).getNumber());
            assertEquals(5000, actualResult.get(0).getValue());
        }
    }
}
