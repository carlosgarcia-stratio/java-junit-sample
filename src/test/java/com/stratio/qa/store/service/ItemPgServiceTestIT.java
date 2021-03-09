package com.stratio.qa.store.service;

import com.stratio.qa.store.model.Item;
import com.stratio.qa.store.service.tools.StaticService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@PrepareForTest({StaticService.class})
public class ItemPgServiceTestIT {

    @Autowired
    private ItemPgService itemService;

    @Test
    public void getItemName() {
        itemService.saveRandomItem(new Item("id1", "name1", "desc1", 10, true));
        Optional<Item> item = itemService.getPgItemById("id1");
        assertThat(item.get().getId(), is("id1"));
    }

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=jdbc:postgresql://localhost:5432/postgres",
                    "spring.datasource.username=postgres",
                    "spring.datasource.password="
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}