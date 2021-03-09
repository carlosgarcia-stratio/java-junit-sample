package com.stratio.qa.store.service;

import com.stratio.qa.store.model.Item;
import com.stratio.qa.store.repository.ItemRepository;
import com.stratio.qa.store.service.tools.StaticService;
import org.springframework.beans.factory.annotation.Autowired;

public class RateService {

    @Autowired
    private ItemRepository itemRepository;


    public int calculateRate(String itemId, int muliplicator) {

        Item item = itemRepository.findById(itemId);
        int rate = item.getPriceInCents() * StaticService.getMultiplicator();
        return rate;
    }

}
