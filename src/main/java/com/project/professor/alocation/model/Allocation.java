package com.project.professor.alocation.model;

import java.sql.Time;
import java.time.DayOfWeek;

public class Allocation {

	private Long id;
	private DayOfWeek day;
	private Time end;
	private Time start;

	public Allocation() {
		super();
	}

	public Allocation(Long id, DayOfWeek day, Time end, Time start) {
		super();
		this.id = id;
		this.day = day;
		this.end = end;
		this.start = start;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public Time getEnd() {
		return end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}

	public Time getStart() {
		return start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	

}
