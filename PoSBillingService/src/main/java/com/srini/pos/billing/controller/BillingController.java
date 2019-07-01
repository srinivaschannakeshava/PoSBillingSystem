package com.srini.pos.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srini.pos.billing.dao.models.BillDetail;
import com.srini.pos.billing.service.BillingService;

@RestController
@RequestMapping(path = "/api/billing")
public class BillingController {
	@Autowired
	BillingService billServ;

	@GetMapping
	public List<BillDetail> getBillDetails() {
		return billServ.getBilldeDetails();
	}
}
