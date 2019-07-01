package com.srini.pos.billing.dao.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class BillDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long billNo;

	private Date date;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Item> items;
	private double totalPrice;

}
