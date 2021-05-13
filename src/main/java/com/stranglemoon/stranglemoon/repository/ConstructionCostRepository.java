package com.stranglemoon.stranglemoon.repository;

import com.stranglemoon.stranglemoon.model.ConstructionCost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructionCostRepository extends CrudRepository<ConstructionCost, Long> {

}
