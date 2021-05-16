package com.stranglemoon.stranglemoon.controller;

import com.stranglemoon.stranglemoon.model.Inventory;
import com.stranglemoon.stranglemoon.repository.InventoryRepository;
import com.stranglemoon.stranglemoon.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("/inventories")
    public Iterable<Inventory> getInventories() {
        return inventoryService.getInventories();
    }


    @PutMapping(value = "/inventories/{id}")
    public @ResponseBody Inventory updateInventory(@PathVariable("id") long id) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);
        Inventory inventory = optionalInventory.get();
        inventory.setGold(inventory.getGold() + 10);
        inventory.setCarrot(inventory.getCarrot() - 1);

        inventoryRepository.save(inventory);
        return inventory;
    }



}
