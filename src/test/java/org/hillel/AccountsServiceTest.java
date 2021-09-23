package org.hillel;

import daos.AccountDAO;
import dto.AccountDto;
import entities.Account;
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
        private AccountDAO accountDao;
        private AccountService accountService;

        @BeforeEach
        public void setUp() {
            this.accountService = new AccountService(accountDao);
        }

        @Test
        public void findAllAccounts() {

            Account account = new Account();
            account.setId(1);
            account.setClientId(1);
            account.setNumber("UA2625");
            account.setValue(5000);

            when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));

            List<AccountDto> actualResult = accountService.findAllAccounts();

            assertEquals(1, actualResult.size());
            assertEquals(1, actualResult.get(0).getId());
            assertEquals(1, actualResult.get(0).getClientId());
            assertEquals("UA2625", actualResult.get(0).getNumber());
            assertEquals(5000, actualResult.get(0).getValue());
        }
    }
}
