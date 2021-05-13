package com.stranglemoon.stranglemoon.controller;

import com.stranglemoon.stranglemoon.model.Inventory;
import com.stranglemoon.stranglemoon.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventories")
    public Iterable<Inventory> getInventories() {
        return inventoryService.getInventories();
    }
}
