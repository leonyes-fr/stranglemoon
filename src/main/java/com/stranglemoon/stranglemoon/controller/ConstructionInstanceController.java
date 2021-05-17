package com.stranglemoon.stranglemoon.controller;

import com.stranglemoon.stranglemoon.model.ConstructionInstance;
import com.stranglemoon.stranglemoon.model.Inventory;
import com.stranglemoon.stranglemoon.repository.ConstructionInstanceRepository;
import com.stranglemoon.stranglemoon.service.ConstructionInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConstructionInstanceController {

    @Autowired
    private ConstructionInstanceService constructionInstanceService;

    @Autowired
    private ConstructionInstanceRepository constructionInstanceRepository;

    @GetMapping("/constructioninstances")
    public Iterable<ConstructionInstance> getConstructionInstances() {
        return constructionInstanceService.getConstructionInstances();

    }

    @PutMapping(value = "/constructioninstance/nextrank/{id}")
    public @ResponseBody
    ConstructionInstance updateTavern(@PathVariable("id") long id) {
        Optional<ConstructionInstance> optionalConstructionInstance = constructionInstanceRepository.findById(id);
        ConstructionInstance constructionInstance = optionalConstructionInstance.get();
        constructionInstance.setActualRank(constructionInstance.getActualRank() + 1);

        constructionInstanceRepository.save(constructionInstance);
        return constructionInstance;
    }

}
