package com.srini.pos.billing.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srini.pos.billing.dao.models.BillDetail;
import com.srini.pos.billing.models.BaseResponse;
import com.srini.pos.billing.service.PrinterService;

@RestController
@RequestMapping(path = "/api/printer")
public class PrinterController {

	@Autowired
	PrinterService printerServ;

	@GetMapping(path = "/all")
	public List<String> printerList() {
		return printerServ.getPrintersList();
	}

	@PostMapping(path = "/{printer}")
	public BaseResponse setPrinter(@PathVariable String printer) {
		printerServ.setPrinter(printer);
		return new BaseResponse();
	}

	@PostMapping(path = "/print/bill")
	public BaseResponse printBill(@RequestBody BillDetail bill) {

		bill.setDate(new Date());
		printerServ.printBill(bill);
		return null;

	}

}
