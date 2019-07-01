package com.srini.pos.billing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srini.pos.billing.dao.models.Inventory;
import com.srini.pos.billing.repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	InventoryRepository inventoryRepo;

	public List<Inventory> getInventory() {
		return inventoryRepo.findAll();
	}

	public boolean addToInventory(Inventory newInventory) {
		Inventory savedInv = inventoryRepo.save(newInventory);
		if (null != savedInv)
			return true;
		else
			return false;

	}

	public boolean updateInventory(Inventory newInventory) {
		Inventory savedInv = inventoryRepo.save(newInventory);
		if (null != savedInv)
			return true;
		else
			return false;

	}

	public void removeFromInventory(String inventoryName) {
		inventoryRepo.deleteById(inventoryName);
	}
}
