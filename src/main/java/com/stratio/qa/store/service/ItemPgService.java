package com.stratio.qa.store.service;

import com.stratio.qa.store.model.Item;
import com.stratio.qa.store.repository.ItemPostgresRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemPgService {

    @Autowired
    private ItemPostgresRepository itemPgRepository;

    public Item saveRandomItem(Item item) { return itemPgRepository.save(item); }

    public Optional<Item> getPgItemById(String itemId) {
        return itemPgRepository.findById(itemId);
    }
}
