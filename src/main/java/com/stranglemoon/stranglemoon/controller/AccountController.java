package com.stranglemoon.stranglemoon.controller;


import com.stranglemoon.stranglemoon.model.Account;
import com.stranglemoon.stranglemoon.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/auth")
    public Optional<Account> getAccountToken() {
        return accountService.getAccountToken(Long.valueOf(1));
    }



    //exemple ou on reprend le body :
    //@PostMapping("/postbody")
    //public String postBody(@RequestBody String fullName) {
    //  return "Hello " + fullName;
    //}

}
