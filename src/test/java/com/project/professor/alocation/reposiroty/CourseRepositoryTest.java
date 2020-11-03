package com.project.professor.alocation.reposiroty;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.alocation.model.Course;
import com.project.professor.alocation.model.Departament;
import com.project.professor.alocation.model.Professor;
import com.project.professor.alocation.repository.CourseRepository;
import com.project.professor.alocation.repository.ProfessorRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void create() { 
		
		Course course = new Course();
		course.setId(null);
		course.setName("Física");
		
		course = courseRepository.save(course);
		
		System.out.println(course);
	}
	
	public Course create(Course course) {
	return courseRepository.save(course);
	}
	
	@Test
	public void readAll() {          //ERRO
		List<Course> courses = courseRepository.findAll(); 
		
		for (Course course : courses) {
			System.out.println(courses.toString());
		}
	}
	
	@Test
	public void readById() {        //ERRO
		Long id = 1L;
		Optional<Course> optionalCourse = courseRepository.findById(id);
		Course course = optionalCourse.orElse(null);
		System.out.println(course);
	}
	
	@Test 
	public void update() {
		Course course = new Course();
		course.setId(null);
		course.setName("Física");
		course = courseRepository.save(course);
	
	    System.out.println(course);	
	}
	
	@Test
	public void deleteAll() {
		courseRepository.deleteAllInBatch();
	}
	
	@Test
	public void deleteById() {
		Long id = 1L;
		courseRepository.deleteById(id);
	}	
}
