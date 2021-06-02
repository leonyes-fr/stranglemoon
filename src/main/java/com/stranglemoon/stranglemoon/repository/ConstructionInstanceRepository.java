package com.stranglemoon.stranglemoon.repository;

import com.stranglemoon.stranglemoon.model.ConstructionInstance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConstructionInstanceRepository extends CrudRepository<ConstructionInstance, Long> {

    @Query(value = "SELECT * FROM construction_instance c where c.account_id= :id", nativeQuery = true)
    Iterable<ConstructionInstance> getByUser(long id);

}
