package com.srini.pos.billing.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srini.pos.billing.dao.models.Inventory;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, String> {

	@Override
	List<Inventory> findAll();

}
