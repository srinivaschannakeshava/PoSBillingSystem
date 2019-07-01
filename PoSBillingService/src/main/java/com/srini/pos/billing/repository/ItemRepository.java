package com.srini.pos.billing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srini.pos.billing.dao.models.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}
