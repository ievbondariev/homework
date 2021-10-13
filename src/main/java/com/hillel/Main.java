package com.hillel;

import com.hillel.config.DatabaseConfig;
import com.hillel.services.AccountService;
import com.hillel.services.ClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        ClientService clientService = (ClientService) context.getBean("clientService");
        clientService.findAllClients().forEach(System.out::println);
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.findAllAccounts().forEach(System.out::println);
    }
}