package com.srini.pos.billing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srini.pos.billing.dao.models.BillDetail;
import com.srini.pos.billing.repository.BillDetailRepository;

@Service
public class BillingService {

	@Autowired
	BillDetailRepository billRepo;

	public List<BillDetail> getBilldeDetails() {
		return billRepo.findAll();
	}

}
