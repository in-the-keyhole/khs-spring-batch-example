package com.khs.batch.timesheet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.khs.batch.dao.TimesheetJPADao;
import com.khs.batch.model.Timesheet;
import com.khs.batch.report.Data;
import com.khs.batch.report.ReportReader;

public class TimesheetReportReader extends ReportReader<Timesheet> {

	@Autowired
	TimesheetJPADao dao;

	@Override
	public List<Timesheet> doQuery() {
		List<Timesheet> results = dao.findAll();
		return results;
	}

	@Override
	public List<Data> mapItem(Timesheet o) {

		List<Data> cols = new ArrayList<Data>();

		Data d = new Data();
		d.setId(com.khs.batch.timesheet.ExampleTimesheetReportFactory.WEEKEND);
		d.setValue(o.getWeek());

		cols.add(d);

		d = new Data();
		d.setId(com.khs.batch.timesheet.ExampleTimesheetReportFactory.COMPANY);
		d.setValue(o.getCompany());

		cols.add(d);

		d = new Data();
		d.setId(com.khs.batch.timesheet.ExampleTimesheetReportFactory.HOURS);
		d.setValue(o.total());

		cols.add(d);

		return cols;
	}

}
