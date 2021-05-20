package com.stranglemoon.stranglemoon.controller;

import com.stranglemoon.stranglemoon.model.ConstructionInstance;
import com.stranglemoon.stranglemoon.service.ConstructionInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConstructionInstanceController {

    @Autowired
    private ConstructionInstanceService constructionInstanceService;



    @GetMapping("/constructioninstances")
    public Iterable<ConstructionInstance> getConstructionInstances() {
        return constructionInstanceService.getConstructionInstances();

    }

    @PutMapping(value = "/constructioninstance/nextrank/{id}")
    public @ResponseBody
    ConstructionInstance updateTavern(@PathVariable("id") long id) {
        return constructionInstanceService.updateRank(id);
    }

}
