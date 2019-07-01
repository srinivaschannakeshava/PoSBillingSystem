package com.srini.pos.billing.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srini.pos.billing.dao.models.BillDetail;

@Repository
public interface BillDetailRepository extends CrudRepository<BillDetail, Long> {
	@Override
	List<BillDetail> findAll();
}
