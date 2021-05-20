package com.stranglemoon.stranglemoon.service;

import com.stranglemoon.stranglemoon.model.ConstructionCost;
import com.stranglemoon.stranglemoon.model.ConstructionInstance;
import com.stranglemoon.stranglemoon.model.Inventory;
import com.stranglemoon.stranglemoon.repository.ConstructionInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConstructionInstanceService {

    @Autowired
    private ConstructionInstanceRepository constructionInstanceRepository;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ConstructionCostService constructionCostService;

    public Optional<ConstructionInstance> getConstructionInstance(final Long id) {
        return constructionInstanceRepository.findById(id);
    }

    public Iterable<ConstructionInstance> getConstructionInstances() {
        return constructionInstanceRepository.findAll();
    }

    public ConstructionInstance saveConstructionInstance(ConstructionInstance constructionInstance) {
        return constructionInstanceRepository.save(constructionInstance);
    }

    public ConstructionInstance updateRank(long id) {
        Optional<ConstructionInstance> optionalConstructionInstance = this.getConstructionInstance(id);
        ConstructionInstance constructionInstance = optionalConstructionInstance.get();  // j'ai mon instance de taverne avec son actual Rank

        Optional<ConstructionCost> optionalConstructionCost = constructionCostService.getConstructionCost(new Long(constructionInstance.getActualRank()));
        ConstructionCost constructionCost = optionalConstructionCost.get(); // Je prend le cout de construction d'une taverne ou l'id est = a actual Rank de mon instance.

        Inventory inventory = inventoryService.getInventories().iterator().next();  //je prend mon inventaire perso.

        if (inventory.getGold() - constructionCost.getTavern() > 0) {  // Si 100 - 20 > 0 alors...
            inventory.setGold(inventory.getGold() - constructionCost.getTavern());
            constructionInstance.setActualRank(constructionInstance.getActualRank() + 1);
            this.saveConstructionInstance(constructionInstance);
            return constructionInstance;
        }else {
            return constructionInstance;
        }
    }

}
