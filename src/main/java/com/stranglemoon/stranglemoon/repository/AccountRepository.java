package com.stranglemoon.stranglemoon.repository;

import com.stranglemoon.stranglemoon.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query(value = "INSERT INTO account (username, password, token) values(:username, :password, '789')", nativeQuery = true)
    Account addAccount(String username, String password);

    @Query(value = "SELECT * FROM account a where a.username= :username and a.password= :password", nativeQuery = true)
    Account findAccount(String username, String password);

    @Query(value = "SELECT * FROM account a where a.token= :token", nativeQuery = true)
    Account getActualUser(String token);


}
