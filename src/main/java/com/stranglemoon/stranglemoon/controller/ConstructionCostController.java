package com.stranglemoon.stranglemoon.controller;

import com.stranglemoon.stranglemoon.model.ConstructionCost;
import com.stranglemoon.stranglemoon.service.ConstructionCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConstructionCostController {

    @Autowired
    private ConstructionCostService constructionCostService;

    @GetMapping("/constructioncost")
    public Iterable<ConstructionCost> getConstructionCosts() {
        return constructionCostService.getConstructionCosts();
    }

}
