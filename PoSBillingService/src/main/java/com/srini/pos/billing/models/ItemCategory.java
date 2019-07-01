package com.srini.pos.billing.models;

import lombok.Getter;

@Getter
public enum ItemCategory {
	FOOD("food"), BEVERAGES("beverages"), SNACKS("snacks");

	private String value;

	ItemCategory(String value) {
		this.value = value;
	}

}
