package com.khs.batch.timesheet;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.khs.batch.model.Timesheet;

public class TimesheetFieldSetMapper implements FieldSetMapper<Timesheet> {


	public Timesheet mapFieldSet(FieldSet field) throws BindException {

		Timesheet ts = new Timesheet();
		ts.setCompany(field.readString("company"));
		ts.setWeek(field.readDate("week"));
		ts.setMonday(field.readFloat("monday"));
		ts.setTuesday(field.readFloat("tuesday"));
		ts.setWednesday(field.readFloat("wednesday"));
		ts.setThursday(field.readFloat("thursday"));
		ts.setFriday(field.readFloat("friday"));
		ts.setSaturday(field.readFloat("saturday"));
		ts.setSunday(field.readFloat("sunday"));

		return ts;
	}

}
