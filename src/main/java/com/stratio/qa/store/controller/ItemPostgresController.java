package com.stratio.qa.store.controller;

import com.stratio.qa.store.model.Item;
import com.stratio.qa.store.service.ItemPgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ItemPostgresController {

    @Autowired
    ItemPgService itemService;

    @GetMapping("findById")
    Optional<Item> getItem(@RequestParam String itemId) {
       return itemService.getPgItemById(itemId);
    }

    @PostMapping("/newRandomItem")
    Item newEmployee(@RequestBody Item item) {
        return itemService.saveRandomItem(item);
    }
}
