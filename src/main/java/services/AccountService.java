package services;

import daos.AccountDAO;
import dto.AccountDto;
import entities.Account;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private static final Logger logger = Logger.getLogger(AccountService.class);

    private AccountDAO accountDao;

    public AccountService(AccountDAO accountDAO) {
        this.accountDao = accountDAO;
        logger.debug("AccountDao configured");
    }

    public AccountService() {
    }

    public List<AccountDto> findAllAccounts() {
        List<Account> accounts = accountDao.findAllAccounts();
        List<AccountDto> accountDtos = new ArrayList<>();

        for (Account account : accounts) {
            AccountDto accountDto = new AccountDto();
            accountDto.setId(account.getId());
            accountDto.setClientId(account.getClientId());
            accountDto.setNumber(account.getNumber());
            accountDto.setValue(account.getValue());
            accountDtos.add(accountDto);
        }
        logger.debug("AccountService started");
        return accountDtos;
    }
}
