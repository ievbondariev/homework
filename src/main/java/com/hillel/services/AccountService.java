package com.hillel.services;

import com.hillel.daos.AccountDAO;
import com.hillel.dto.AccountDto;
import com.hillel.entities.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private AccountDAO accountDao;

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

    public void setAccountDao(AccountDAO accountDao) {
        this.accountDao = accountDao;
    }
}
