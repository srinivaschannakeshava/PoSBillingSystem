package com.srini.pos.billing.dao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.srini.pos.billing.models.ItemCategory;

import lombok.Data;

@Entity
@Data
public class Inventory {
	@Id
	@Column(name = "name", unique = true, columnDefinition = "VARCHAR(10)")
	private String name;
	private double price;
//	@Enumerated(EnumType.STRING)
	private ItemCategory category;

}
