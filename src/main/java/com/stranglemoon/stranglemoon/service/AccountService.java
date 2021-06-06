package com.stranglemoon.stranglemoon.service;

import com.stranglemoon.stranglemoon.model.Account;
import com.stranglemoon.stranglemoon.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional
    public void addAccount(String username, String password) {
        entityManager.createNativeQuery("INSERT INTO account (username, password, token) values(?, ?, ?)")
                .setParameter(1, username) // travailler en objet en remplacant les string par l'objet account !
                .setParameter(2, password)
                .setParameter(3, username)
                .executeUpdate();
    }

    public Optional<Account> getAccountToken(Long id) {
        return accountRepository.findById(id);
    }

    public Account getActualUser(String token) {
        return accountRepository.getActualUser(token);

    }


}
