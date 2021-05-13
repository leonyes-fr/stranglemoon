package com.stranglemoon.stranglemoon.service;

import com.stranglemoon.stranglemoon.model.ConstructionCost;
import com.stranglemoon.stranglemoon.repository.ConstructionCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConstructionCostService {

    @Autowired
    private ConstructionCostRepository constructionCostRepository;

    public Optional<ConstructionCost> getConstructionCost(final Long id) {
        return constructionCostRepository.findById(id);
    }

    public Iterable<ConstructionCost> getConstructionCosts() {
        return constructionCostRepository.findAll();
    }




}
