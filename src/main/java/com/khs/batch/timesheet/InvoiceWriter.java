package com.khs.batch.timesheet;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.khs.batch.dao.InvoiceJPADao;
import com.khs.batch.model.InvoiceItem;

public class InvoiceWriter implements ItemWriter<InvoiceItem> {

	@Autowired
	InvoiceJPADao dao;

	@Override
	public void write(List<? extends InvoiceItem> items) throws Exception {

		for (InvoiceItem invoice : items) {
			System.out.println("Invoice = " + invoice);
			dao.persist(invoice);
		}

	}
}
