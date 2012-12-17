package com.khs.batch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "timesheet")
public class Timesheet {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String company;

	@Column
	@Temporal(TemporalType.DATE)
	private Date week;

	@Column
	private float monday;

	@Column
	private String mondayNotes;

	@Column
	private float tuesday;

	@Column
	private String tuesdayNotes;

	@Column
	private float wednesday;

	@Column
	private String wednesdayNotes;

	@Column
	private float thursday;

	@Column
	private boolean submitted;

	@ManyToOne
	private Employee employee;

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}

	@Column
	private String thursdayNotes;

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Column
	private float friday;

	@Column
	private String fridayNotes;

	@Column
	private float saturday;

	@Column
	private String saturdayNotes;

	@Column
	private float sunday;

	@Column
	private String sundayNotes;

	public String getMondayNotes() {
		return mondayNotes;
	}

	public void setMondayNotes(String mondayNotes) {
		this.mondayNotes = mondayNotes;
	}

	public String getTuesdayNotes() {
		return tuesdayNotes;
	}

	public void setTuesdayNotes(String tuesdayNotes) {
		this.tuesdayNotes = tuesdayNotes;
	}

	public String getWednesdayNotes() {
		return wednesdayNotes;
	}

	public void setWednesdayNotes(String wednesdayNotes) {
		this.wednesdayNotes = wednesdayNotes;
	}

	public String getThursdayNotes() {
		return thursdayNotes;
	}

	public void setThursdayNotes(String thursdayNotes) {
		this.thursdayNotes = thursdayNotes;
	}

	public String getFridayNotes() {
		return fridayNotes;
	}

	public void setFridayNotes(String fridayNotes) {
		this.fridayNotes = fridayNotes;
	}

	public String getSaturdayNotes() {
		return saturdayNotes;
	}

	public void setSaturdayNotes(String saturdayNotes) {
		this.saturdayNotes = saturdayNotes;
	}

	public String getSundayNotes() {
		return sundayNotes;
	}

	public void setSundayNotes(String sundayNotes) {
		this.sundayNotes = sundayNotes;
	}

	@Column
	private boolean approved;

	@Column
	private String notes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getWeek() {
		return week;
	}

	public void setWeek(Date week) {
		this.week = week;
	}

	public float getMonday() {
		return monday;
	}

	public void setMonday(float monday) {
		this.monday = monday;
	}

	public float getTuesday() {
		return tuesday;
	}

	public void setTuesday(float tuesday) {
		this.tuesday = tuesday;
	}

	public float getWednesday() {
		return wednesday;
	}

	public void setWednesday(float wednesday) {
		this.wednesday = wednesday;
	}

	public float getThursday() {
		return thursday;
	}

	public void setThursday(float thursday) {
		this.thursday = thursday;
	}

	public float getFriday() {
		return friday;
	}

	public void setFriday(float friday) {
		this.friday = friday;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public float getSaturday() {
		return saturday;
	}

	public void setSaturday(float saturday) {
		this.saturday = saturday;
	}

	public float getSunday() {
		return sunday;
	}

	public void setSunday(float sunday) {
		this.sunday = sunday;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public float total() {

		return getMonday() + getTuesday() + getWednesday() + getThursday() + getFriday() + getSaturday() + getSunday();
	}

}
