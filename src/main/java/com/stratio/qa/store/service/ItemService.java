package com.stratio.qa.store.service;

import com.stratio.qa.store.model.Item;
import com.stratio.qa.store.repository.ItemPostgresRepository;
import com.stratio.qa.store.repository.ItemRepository;
import com.stratio.qa.store.service.tools.StaticService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemPostgresRepository itemPgRepository;

    public int getAveragePriceForAllItems() {

        List<Item> items = itemRepository.readAllItems();

        int sumOfPrices = 0;
        for (Item item : items) {
            sumOfPrices += item.getPriceInCents();
        }

        return (sumOfPrices / items.size()) * StaticService.getMultiplicator();
    }

    public String readItemDescription(String fileName) {

        String ret = "";

        try {
            ret = StaticService.readFile(fileName);
        } catch (IOException e) {
            // Do some logging and proceed
        }

        return ret;
    }

    public String getItemNameUpperCase(String itemId) {

        Item item = itemRepository.findById(itemId);

        return StringUtils.upperCase(item.getName());
    }

}
