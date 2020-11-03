package com.project.professor.alocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.alocation.model.Departament;
import com.project.professor.alocation.model.Professor;
import com.project.professor.alocation.service.ProfessorService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorServiceTest {

	@Autowired
	ProfessorService professorService;

	@Test
	public void findAll() {
		String name = null;

		List<Professor> professors = professorService.findAll(name);

		professors.forEach(System.out::println);
	}

	@Test
	public void findById() {
		
		Long id = 1L;

		Professor professor = professorService.findById(id);

		System.out.println(professor);
	}

	@Test
	public void create() {
		
		Departament departament = new Departament();
		departament.setId(1L);

		Professor professor = new Professor();
		professor.setId(null);
		professor.setName("Professor 1");
		professor.setCpf("111.111.111-11");
		professor.setDepartament(departament);

		professor = professorService.create(professor);

		System.out.println(professor);
	}

	@Test
	public void update() {
		
		Departament departament = new Departament();
		departament.setId(null);

		Professor professor = new Professor();
		professor.setId(null);
		professor.setName("Professor 2");
		professor.setCpf("222.222.222-22");
		professor.setDepartament(departament);

		professor = professorService.update(professor);

		System.out.println(professor);
	}

	@Test
	public void deleteById() {
		// Arrange
		Long id = 1L;

		// Act
		professorService.deleteById(id);
	}

	@Test
	public void deleteAll() {
		// Act
		professorService.deleteAll();
	}
}



