package com.khs.batch.timesheet;

import java.util.Arrays;
import java.util.List;

import com.khs.batch.report.Column;
import com.khs.batch.report.ReportFactory;

/**
 * Example Timesheet report format (i.e. columns,headings, footings, groupings, totaling, etc..)
 * 
 * @author dpitt www.keyholesoftware.com
 */
public class ExampleTimesheetReportFactory extends ReportFactory {
	// column ids
	public final static String WEEKEND = "Weekend";
	public final static String DEPARTMENT = "department";
	public final static String COMPANY = "Company";
	public final static String HOURS = "hours";

	@Override
	// Report Header List
	// Each element in list is a header line
	// ~ is used to justify header text LEFT,CENTER,RIGHT
	public List<String> getHeader() {
		return Arrays.asList("Example Report", "~Example Timesheet Report~Page #");
	}

	@Override
	// Report Columns Column definitions options...
	// Column.New(<col id>,<col value>).group()
	// Column.New(<col id>,<col value>).total()
	public List<Column> getColumns() {
		return Arrays.asList(Column.New(WEEKEND, "Weekend"), Column.New(COMPANY, COMPANY).group(), Column.New(HOURS, "Hours").total());
	}

	@Override
	// Report Footer List
	// Each element in list is a header line
	// ~ is used to justify header text LEFT,CENTER,RIGHT
	public List<String> getFooter() {
		return Arrays.asList("~Footer for ");
	}
}
