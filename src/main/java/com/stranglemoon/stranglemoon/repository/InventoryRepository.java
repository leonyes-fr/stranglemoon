package com.stranglemoon.stranglemoon.repository;

import com.stranglemoon.stranglemoon.model.Inventory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {

    @Query(value = "SELECT * FROM inventory c where c.account_id= :id", nativeQuery = true)
    Iterable<Inventory> getByUser(long id);

}
