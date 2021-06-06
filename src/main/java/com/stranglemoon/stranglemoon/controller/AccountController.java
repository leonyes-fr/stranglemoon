package com.stranglemoon.stranglemoon.controller;

import com.stranglemoon.stranglemoon.model.Account;
import com.stranglemoon.stranglemoon.repository.AccountRepository;
import com.stranglemoon.stranglemoon.service.AccountService;
import com.stranglemoon.stranglemoon.service.ConstructionInstanceService;
import com.stranglemoon.stranglemoon.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ConstructionInstanceService constructionInstanceService;

    @PostMapping("/createaccount")
    public Account createAccount(@RequestBody Account credential) {
        // add account dans account
        accountService.addAccount(credential.getUsername(), credential.getPassword());
        Account createdUser = accountRepository.findAccount(credential.getUsername(), credential.getPassword());
        // add un new inventory
        inventoryService.addInventory(createdUser.getId());
        // add un new Construction_instance
        constructionInstanceService.addConstructionInstance(createdUser.getId());

        return accountRepository.findAccount(credential.getUsername(), credential.getPassword());
    }

    @PostMapping("/auth")
    public Account getAccountToken(@RequestBody Account credential) {
        return accountRepository.findAccount(credential.getUsername(), credential.getPassword());
    }

}
