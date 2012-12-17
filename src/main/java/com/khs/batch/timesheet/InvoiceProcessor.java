package com.khs.batch.timesheet;

import org.springframework.batch.item.ItemProcessor;

import com.khs.batch.model.InvoiceItem;
import com.khs.batch.model.Timesheet;

/**
 * Create invoice record for each Timesheets
 * 
 * @author dpitt www.keyholesoftware.com
 * 
 */

public class InvoiceProcessor implements ItemProcessor<Timesheet, InvoiceItem> {

	@Override
	public InvoiceItem process(Timesheet ts) throws Exception {

		InvoiceItem item = new InvoiceItem();
		item.setCompany(ts.getCompany());
		item.setAmount(ts.total() * 100.00);

		return item;
	}
}
