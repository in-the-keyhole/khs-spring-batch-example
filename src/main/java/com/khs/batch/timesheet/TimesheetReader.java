package com.khs.batch.timesheet;

import java.util.List;

import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.khs.batch.dao.TimesheetJPADao;
import com.khs.batch.model.Timesheet;

public class TimesheetReader implements ItemReader<Timesheet> {

	List<Timesheet> timesheets;
	int current = 0;

	@Autowired
	TimesheetJPADao dao;

	@BeforeStep
	public void init() {
		timesheets = dao.findAll();
	}

	@AfterStep
	public void reset() {
		timesheets = null;
		current = 0;
	}

	
	public Timesheet read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		Timesheet ts = null;
		if (current < timesheets.size()) {
			ts = timesheets.get(current);
			current++;
		}
		return ts;
	}
}
