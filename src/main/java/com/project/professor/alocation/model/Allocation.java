package com.project.professor.alocation.model;

import java.sql.Time;
import java.time.DayOfWeek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "allocation")
public class Allocation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

@Enumerated(value = EnumType.STRING)
@Column(name = "day", nullable = false)
	private DayOfWeek day;
	
@Column(name ="end", nullable = false, columnDefinition = "TIME")
    private Time end;
@Column(name ="start", nullable = false, columnDefinition = "TIME")
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
