package com.stranglemoon.stranglemoon.repository;

import com.stranglemoon.stranglemoon.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {


}
