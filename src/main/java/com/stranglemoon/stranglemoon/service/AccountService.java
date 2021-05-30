package com.stranglemoon.stranglemoon.service;

import com.stranglemoon.stranglemoon.model.Account;
import com.stranglemoon.stranglemoon.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> getAccountToken(Long id) {
        return accountRepository.findById(id);
    }
}
