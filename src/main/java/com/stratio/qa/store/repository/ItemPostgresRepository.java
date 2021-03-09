package com.stratio.qa.store.repository;

import com.stratio.qa.store.model.Item;
import org.springframework.data.repository.CrudRepository;


public interface ItemPostgresRepository extends CrudRepository<Item, String> {
}
