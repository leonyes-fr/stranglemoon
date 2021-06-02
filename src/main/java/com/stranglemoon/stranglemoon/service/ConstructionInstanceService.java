package com.stranglemoon.stranglemoon.service;

import com.stranglemoon.stranglemoon.model.Account;
import com.stranglemoon.stranglemoon.model.ConstructionCost;
import com.stranglemoon.stranglemoon.model.ConstructionInstance;
import com.stranglemoon.stranglemoon.model.Inventory;
import com.stranglemoon.stranglemoon.repository.ConstructionInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Optional;

@Service
public class ConstructionInstanceService {

    @Autowired
    private ConstructionInstanceRepository constructionInstanceRepository;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ConstructionCostService constructionCostService;

    @Autowired
    private AccountService accountService;

    public Optional<ConstructionInstance> getConstructionInstance(final Long id) {
        return constructionInstanceRepository.findById(id);
    }

    public Iterable<ConstructionInstance> getConstructionInstances(String token) { // récuperer tous les batiments ou l'id = l'user actuel.
        Account user = accountService.getActualUser(token);
        return constructionInstanceRepository.getByUser(user.getId());
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

        if (constructionInstance.getName().equals("tavern")){
            if ((inventory.getGold() - constructionCost.getTavern()) >= 0) {
                inventory.setGold(inventory.getGold() - constructionCost.getTavern());
                constructionInstance.setActualRank(constructionInstance.getActualRank() + 1);
                this.saveConstructionInstance(constructionInstance);
                return constructionInstance;
            }
        }else if (constructionInstance.getName().equals("farm")) {
            if ((inventory.getGold() - constructionCost.getFarm()) >= 0) {
                inventory.setGold(inventory.getGold() - constructionCost.getFarm());
                constructionInstance.setActualRank(constructionInstance.getActualRank() + 1);
                this.saveConstructionInstance(constructionInstance);
                return constructionInstance;
            }
        }
        return constructionInstance;
    }

}
