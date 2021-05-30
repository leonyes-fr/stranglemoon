package com.stranglemoon.stranglemoon.controller;


import com.stranglemoon.stranglemoon.model.Account;
import com.stranglemoon.stranglemoon.repository.AccountRepository;
import com.stranglemoon.stranglemoon.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/auth")
    public Optional<Account> getAccountToken(@RequestBody List<String> credentials) {

        String username = credentials.get(0);
        String password = credentials.get(1);
        return accountRepository.findAccount(username, password);



    }

}
