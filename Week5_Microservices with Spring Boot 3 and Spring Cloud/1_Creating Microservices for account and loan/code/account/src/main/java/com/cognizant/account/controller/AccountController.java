package com.cognizant.account.controller;

import com.cognizant.account.exception.AccountNotFoundException;
import com.cognizant.account.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{number}")
    public Object getAccountDetails(@PathVariable(name = "number") String accountNumber) {
        try {
            return accountService.getAccountDetails(accountNumber);
        } catch (AccountNotFoundException e) {
            LOGGER.error("Account Not found: {}", e.getMessage());
            return accountNumber + " not found!";
        } catch (RuntimeException e) {
            LOGGER.error("Error: {}", e.getMessage());
            return "Error: " + e.getMessage();
        }
    }
}
