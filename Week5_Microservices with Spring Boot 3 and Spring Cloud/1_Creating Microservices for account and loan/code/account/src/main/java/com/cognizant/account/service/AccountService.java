package com.cognizant.account.service;

import com.cognizant.account.exception.AccountNotFoundException;
import com.cognizant.account.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final List<Account> accounts;

    AccountService() {
        accounts = List.of(
                new Account("00987987973432", "savings", 234343),
                new Account("00847987973432", "savings", 5334343)
        );
    }


    public Account getAccountDetails(String accountNumber) {
        return accounts.stream().filter(acc -> acc.getNumber().equals(accountNumber)).findFirst()
                .orElseThrow(() -> new AccountNotFoundException("Account Not found: " + accountNumber));
    }
}
