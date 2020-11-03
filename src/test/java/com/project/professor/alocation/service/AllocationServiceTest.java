package com.project.professor.alocation.service;


import java.sql.Time;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.alocation.model.Allocation;
import com.project.professor.alocation.model.Course;
import com.project.professor.alocation.model.Professor;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationServiceTest {

	@Autowired
	AllocationService allocationService;

	@Test
	public void findAll() {
		List<Allocation> allocations = allocationService.findAll();
		allocations.forEach(System.out::println);
	}
	
	@Test
	public void findByProfessor() {
		
		Long id = 1L;
		List<Allocation> allocations = allocationService.findByProfessor(id);
		allocations.forEach(System.out::println);
	}
	
	@Test
	public void findByCourse() {
		Long id = 1L;
		List<Allocation> allocations = allocationService.findByCourse(id);
		allocations.forEach(System.out::println);
	}
	
	@Test
	public void findById() {
		Long id = 1L;
		Allocation allocation = allocationService.findById(id);
		System.out.println(allocation);
	}
	
	@Test
	public void create() {
		Professor professor = new Professor();
		professor.setId(1L);

		Course course = new Course();
		course.setId(1L);

		Allocation allocation = new Allocation();
		allocation.setId(null);
		allocation.setDay(DayOfWeek.WEDNESDAY);
		allocation.setStart(Time.valueOf("19:00:00"));
		allocation.setEnd(Time.valueOf("20:00:00"));
		allocation.setProfessor(professor);
		allocation.setCourse(course);

		allocation = allocationService.create(allocation);

		System.out.println(allocation);
	}
	
	
	
}	
	