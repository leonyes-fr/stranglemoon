package com.stranglemoon.stranglemoon.service;

import com.stranglemoon.stranglemoon.model.ConstructionInstance;
import com.stranglemoon.stranglemoon.repository.ConstructionInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConstructionInstanceService {

    @Autowired
    private ConstructionInstanceRepository constructionInstanceRepository;

    public Optional<ConstructionInstance> getConstructionInstance(final Long id) {
        return constructionInstanceRepository.findById(id);
    }

    public Iterable<ConstructionInstance> getConstructionInstances() {
        return constructionInstanceRepository.findAll();
    }

}
