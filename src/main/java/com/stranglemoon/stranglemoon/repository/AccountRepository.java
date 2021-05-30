package com.stranglemoon.stranglemoon.repository;

import com.stranglemoon.stranglemoon.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {


    @Query(value = "SELECT * FROM account a where a.username= :username and a.password= :password", nativeQuery = true)
    Optional<Account> findAccount(String username, String password);


 //   @Query(value="select * from author a where a.first_name= :firstName", nativeQuery=true)
   // List<Author> getAuthorsByFirstName(String firstName);

}
