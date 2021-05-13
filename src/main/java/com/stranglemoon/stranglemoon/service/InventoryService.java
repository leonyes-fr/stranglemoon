package com.stranglemoon.stranglemoon.service;

import com.stranglemoon.stranglemoon.model.Inventory;
import com.stranglemoon.stranglemoon.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Optional<Inventory> getInventory(final Long id) {
        return inventoryRepository.findById(id);
    }

    public Iterable<Inventory> getInventories() {
        return inventoryRepository.findAll();
    }

}
