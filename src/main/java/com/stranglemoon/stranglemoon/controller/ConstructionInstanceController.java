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

    @GetMapping("/constructioninstances") // récupére les batiments de l'user en cours.
    public Iterable<ConstructionInstance> getConstructionInstances(@RequestHeader("authorization") String token) {
        return constructionInstanceService.getConstructionInstances(token);
    }

    @PutMapping(value = "/constructioninstance/nextrank/{id}")
    public @ResponseBody
    ConstructionInstance updateRank(@PathVariable("id") long id,@RequestHeader("authorization") String token) {
        return constructionInstanceService.updateRank(id, token);
    }

}
