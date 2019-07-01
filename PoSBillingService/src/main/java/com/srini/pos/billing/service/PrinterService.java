package com.srini.pos.billing.service;

import java.awt.print.PrinterJob;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.print.PrintService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srini.pos.billing.config.PoSConfiguration;
import com.srini.pos.billing.converter.PrintFormatter;
import com.srini.pos.billing.dao.models.BillDetail;
import com.srini.pos.billing.repository.BillDetailRepository;

@Service
public class PrinterService {

	@Autowired
	PoSConfiguration posConfig;

	@Autowired
	BillDetailRepository billRepo;

	@Autowired
	PrintFormatter printf;

	public List<String> getPrintersList() {
		return getListPrintServicesNames();
	}

	public void setPrinter(String printer) {
		printf.setPrinterStream(printer);
		posConfig.setPrinter(printer);
	}

	public boolean printBill(BillDetail bill) {
		billRepo.save(bill);
		try {
			printf.format2Print(bill);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Get the name of all printers on the system.
	 * 
	 * @return list of printers names.
	 */
	private List<String> getListPrintServicesNames() {
		PrintService[] printServices = PrinterJob.lookupPrintServices();
		Stream<PrintService> stream = Arrays.stream(printServices);
		List<String> printersList = stream.map(p -> p.getName()).collect(Collectors.toList());
		return printersList;
	}

}
