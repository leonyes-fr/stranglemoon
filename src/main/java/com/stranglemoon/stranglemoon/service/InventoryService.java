package com.stranglemoon.stranglemoon.service;

import com.stranglemoon.stranglemoon.model.Account;
import com.stranglemoon.stranglemoon.model.Inventory;
import com.stranglemoon.stranglemoon.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private AccountService accountService;

    public Optional<Inventory> getInventory(final Long id) {
        return inventoryRepository.findById(id);
    }

    public Iterable<Inventory> getInventories(String token) {
        Account user = accountService.getActualUser(token);
        return inventoryRepository.getByUser(user.getId());
    }

    public Inventory updateGold(long id) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);
        Inventory inventory = optionalInventory.get();
        inventory.setGold(inventory.getGold() + 10);
        inventory.setCarrot(inventory.getCarrot() - 1);

        inventoryRepository.save(inventory);
        return inventory;
    }


    public Inventory updateCarrot(long id) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);
        Inventory inventory = optionalInventory.get();
        inventory.setCarrot(inventory.getCarrot() + 1);

        inventoryRepository.save(inventory);
        return inventory;
    }

}
