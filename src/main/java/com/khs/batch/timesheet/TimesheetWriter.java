package com.khs.batch.timesheet;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.khs.batch.dao.TimesheetJPADao;
import com.khs.batch.model.Timesheet;

public class TimesheetWriter implements ItemWriter<Timesheet> {
	@Autowired
	TimesheetJPADao dao;


	public void write(List<? extends Timesheet> items) throws Exception {

		for (Timesheet ts : items) {
			System.out.println("TS = " + ts);
			dao.persist(ts);
		}

	}
}
