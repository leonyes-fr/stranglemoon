package com.stranglemoon.stranglemoon.controller;

import com.stranglemoon.stranglemoon.model.ConstructionInstance;
import com.stranglemoon.stranglemoon.service.ConstructionInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConstructionInstanceController {

    @Autowired
    private ConstructionInstanceService constructionInstanceService;

    @GetMapping("/constructioninstances")
    public Iterable<ConstructionInstance> getConstructionInstances() {
        return constructionInstanceService.getConstructionInstances();

    }

}
