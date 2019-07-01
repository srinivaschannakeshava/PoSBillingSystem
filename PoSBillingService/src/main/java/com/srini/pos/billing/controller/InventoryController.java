package com.srini.pos.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srini.pos.billing.dao.models.Inventory;
import com.srini.pos.billing.models.BaseResponse;
import com.srini.pos.billing.service.InventoryService;

@RestController
@RequestMapping(path = "/api/inventory")
public class InventoryController {
	@Autowired
	InventoryService inventoryServ;

	@GetMapping
	public List<Inventory> getInventory() {
		return inventoryServ.getInventory();
	}

	@PostMapping(path = "/add")
	public BaseResponse addToInventory(@RequestBody Inventory newInventory) {
		boolean isAdded = inventoryServ.addToInventory(newInventory);
		if (isAdded)
			return new BaseResponse(false, "Added Successfully!!");
		else
			return new BaseResponse(true, "Failed to Add!!");

	}

	@PutMapping(path = "/update")
	public BaseResponse updateInventory(@RequestBody Inventory newInventory) {
		boolean isAdded = inventoryServ.updateInventory(newInventory);
		if (isAdded)
			return new BaseResponse(false, "Updated Successfully!!");
		else
			return new BaseResponse(true, "Failed to Update!!");

	}

	@DeleteMapping(path = "/remove/{inventoryName}")
	public BaseResponse removeFromInventory(@PathVariable String inventoryName) {
		inventoryServ.removeFromInventory(inventoryName);
		return new BaseResponse(false, "Removed Successfully!!");
	}

}
