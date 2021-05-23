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

    public ConstructionInstance updateRank(long id) { // recoit 1 pour taverne par exemple
        Optional<ConstructionInstance> optionalConstructionInstance = this.getConstructionInstance(id);
        ConstructionInstance constructionInstance = optionalConstructionInstance.get();  // j'ai mon instance de taverne avec son actual Rank genre id1 name tavern actualrank

        Optional<ConstructionCost> optionalConstructionCost = constructionCostService.getConstructionCost((long) constructionInstance.getActualRank() + 1);
        ConstructionCost constructionCost = optionalConstructionCost.get(); // Je prend le cout de construction d'une taverne ou l'id est = a actual Rank de mon instance.

        Inventory inventory = inventoryService.getInventories().iterator().next();  //je prend mon inventaire perso.


        // faire un if getconstructionInstance.name = tavern alors getTavern aprés. sinon constructionCost.getFarm etc...

        if ((inventory.getGold() - constructionCost.getTavern()) >= 0) {  //NE MARCHE PAS A CAUSE DE GET TAVERN QUI N ES PAS GENERIQUE !
            inventory.setGold(inventory.getGold() - constructionCost.getTavern()); //NE MARCHE PAS A CAUSE DE GET TAVERN QUI N ES PAS GENERIQUE !
            constructionInstance.setActualRank(constructionInstance.getActualRank() + 1);
            this.saveConstructionInstance(constructionInstance);
            return constructionInstance;
        }else {
            return constructionInstance;
        }
    }

}
