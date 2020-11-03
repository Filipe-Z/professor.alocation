package com.project.professor.alocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.alocation.model.Course;



@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CourseServerTest {

	@Autowired
	CourseService courseService;

	@Test
	public void findAll() {
		String name = null;
		List<Course> courses = courseService.findAll(name);
		courses.forEach(System.out::println);
	}
	
	@Test
	public void findById() {
		Long id = 1L;
		Course course = courseService.findById(id);
		System.out.println(course);
	}
	
	@Test
	public void create() {
		Course course = new Course();
		course.setId(null);
		course.setName("Curso 1");
		course = courseService.create(course);
		System.out.println(course);
	}
	
	@Test
	public void update() {
		Course course = new Course();
		course.setId(1L);
		course.setName("Curso 2");
		course = courseService.update(course);
		System.out.println(course);
	}
	
	@Test
	public void deleteById() {
		Long id = 1L;
		courseService.deleteById(id);
	}

	@Test
	public void deleteAll() {
		courseService.deleteAll();
	}
}
