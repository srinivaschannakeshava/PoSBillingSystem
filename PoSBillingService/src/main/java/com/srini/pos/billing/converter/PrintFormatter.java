package com.srini.pos.billing.converter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.print.PrintService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.srini.pos.billing.config.PoSConfiguration;
import com.srini.pos.billing.config.PrintConstants;
import com.srini.pos.billing.dao.models.BillDetail;
import com.srini.pos.billing.dao.models.Item;
import com.srini.pos.billing.escpos.coffee.EscPos;
import com.srini.pos.billing.escpos.coffee.EscPosConst;
import com.srini.pos.billing.escpos.coffee.EscPosConst.Justification;
import com.srini.pos.billing.escpos.coffee.Style;
import com.srini.pos.billing.escpos.coffee.output.PrinterOutputStream;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
public class PrintFormatter {
	private EscPos escpos;
	private PrintService printService;
	@Autowired
	PoSConfiguration config;

	public PrintFormatter() throws IOException {

	}

	public void setPrinterStream(String printer) {
		printService = PrinterOutputStream.getPrintServiceByName(printer);
	}

	Style title = new Style().setFontSize(Style.FontSize._2, Style.FontSize._2)
			.setJustification(EscPosConst.Justification.Center);
	Style subtitle = new Style().setBold(true)
//			.setUnderline(Style.Underline.OneDotThick)
			.setJustification(Justification.Center);
	Style content = new Style().setBold(false).setJustification(Justification.Center);
	Style bold = new Style().setBold(true).setJustification(Justification.Center);

	String pattern = "dd-MM-yyyy hh:mm a";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	public String format2Print(BillDetail billList)
			throws IllegalArgumentException, UnsupportedEncodingException, IOException {
		String date = simpleDateFormat.format(new Date());
		ContentAndTP contentAndTp = formatToLine(billList.getItems());
		escpos = new EscPos(new PrinterOutputStream(printService));
		escpos.write(title, PrintConstants.name).writeLF(subtitle, PrintConstants.address)
				.write(bold, "Date: " + date + "\n").writeLF(bold, PrintConstants.itemListHeader)
				.write(content, contentAndTp.getContent() + "\n")
				.write(subtitle, "Grand Total: " + contentAndTp.getTotalCost() + "\n")
				.write(bold, PrintConstants.seperator + "\n").writeLF(bold, PrintConstants.finalStm)
				.cut(EscPos.CutMode.FULL).feed(2);
		escpos.close();
		return null;
	}

	private ContentAndTP formatToLine(List<Item> items) {
		StringBuffer sb = new StringBuffer();
		AtomicInteger count = new AtomicInteger(1);
		AtomicInteger price = new AtomicInteger(0);
		items.forEach(i -> {
			int total = i.getPrice() * i.getQuantity();
			sb.append(get3CharString(count.getAndIncrement()) + get16CharString(i.getName())
					+ get3CharString(i.getQuantity()) + get4CharString(i.getPrice()) + get5CharString(total) + "\n");
			price.getAndAdd(total);
		});
		System.out.println(sb.toString());
		return new ContentAndTP(sb.toString() + PrintConstants.seperator, price.get());
	}

// use same for count and quantity
	private String get3CharString(int quan) {
		char[] quanArray = { ' ', ' ', ' ' };
		char[] charArray = Integer.toString(quan).toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			quanArray[i] = charArray[i];
		}
		return String.valueOf(quanArray);
	}

	private String get16CharString(String itemName) {
		char[] nameChar = new char[14];
		char[] ItemChar = itemName.toCharArray();
		for (int i = 0; i < nameChar.length; i++) {
			nameChar[i] = ' ';
		}
		for (int i = 0; i < ItemChar.length; i++) {
			nameChar[i] = ItemChar[i];
		}

		return String.valueOf(nameChar);

	}

	private String get4CharString(int rate) {
		char[] rateArray = { ' ', ' ', ' ', ' ', ' ' };
		char[] charArray = Integer.toString(rate).toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			rateArray[i] = charArray[i];
		}
		return String.valueOf(rateArray);
	}

	private String get5CharString(int total) {
		char[] rateArray = { ' ', ' ', ' ', ' ', ' ' };
		char[] charArray = Integer.toString(total).toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			rateArray[i] = charArray[i];
		}
		return String.valueOf(rateArray);
	}

	@Data
	@AllArgsConstructor
	class ContentAndTP {
		String content;
		int totalCost;
	}
}
