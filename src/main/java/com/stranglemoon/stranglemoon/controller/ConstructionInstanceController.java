package com.stranglemoon.stranglemoon.controller;

import com.stranglemoon.stranglemoon.model.ConstructionCost;
import com.stranglemoon.stranglemoon.model.ConstructionInstance;
import com.stranglemoon.stranglemoon.model.Inventory;
import com.stranglemoon.stranglemoon.service.ConstructionCostService;
import com.stranglemoon.stranglemoon.service.ConstructionInstanceService;
import com.stranglemoon.stranglemoon.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConstructionInstanceController {

    @Autowired
    private ConstructionInstanceService constructionInstanceService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ConstructionCostService constructionCostService;

    @GetMapping("/constructioninstances")
    public Iterable<ConstructionInstance> getConstructionInstances() {
        return constructionInstanceService.getConstructionInstances();

    }

    @PutMapping(value = "/constructioninstance/nextrank/{id}")
    public @ResponseBody
    ConstructionInstance updateTavern(@PathVariable("id") long id) {
        Optional<ConstructionInstance> optionalConstructionInstance = constructionInstanceService.getConstructionInstance(id);
        ConstructionInstance constructionInstance = optionalConstructionInstance.get();  // j'ai mon instance de taverne avec son actual Rank

        Optional<ConstructionCost> optionalConstructionCost = constructionCostService.getConstructionCost(new Long(constructionInstance.getActualRank()));
        ConstructionCost constructionCost = optionalConstructionCost.get(); // Je prend le cout de construction d'une taverne ou l'id est = a actual Rank de mon instance.

        Inventory inventory = inventoryService.getInventories().iterator().next();  //je prend mon inventaire perso.

        if (inventory.getGold() - constructionCost.getTavern() > 0) {  // Si 100 - 20 > 0 alors...
            inventory.setGold(inventory.getGold() - constructionCost.getTavern());
            constructionInstance.setActualRank(constructionInstance.getActualRank() + 1);
            constructionInstanceService.saveConstructionInstance(constructionInstance);
            return constructionInstance;
        }else {
            return constructionInstance;
        }


    }

}
