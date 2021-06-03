package com.stranglemoon.stranglemoon.controller;

import com.stranglemoon.stranglemoon.model.Inventory;
import com.stranglemoon.stranglemoon.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventories")
    public Iterable<Inventory> getInventories(@RequestHeader("authorization") String token) {
        return inventoryService.getInventories(token);
    }

    @PutMapping(value = "/inventories/gold/{id}")
    public @ResponseBody Inventory updateGold(@PathVariable("id") long id) {
        return inventoryService.updateGold(id);
    }

    @PutMapping(value = "/inventories/carrot/{id}")
    public @ResponseBody Inventory updateCarrot(@PathVariable("id") long id) {
        return inventoryService.updateCarrot(id);
    }



}
