package services;

import daos.AccountDAO;
import dto.AccountDto;
import entities.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private AccountDAO accountDao;

    public AccountService(AccountDAO accountDAO) {
        this.accountDao = accountDAO;
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
        return accountDtos;
    }
}
