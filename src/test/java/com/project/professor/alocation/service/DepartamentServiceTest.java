package com.project.professor.alocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.alocation.model.Departament;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class DepartamentServiceTest {

	@Autowired
	DepartamentService departamentService;
	
	@Test
	public void readAll_1() {
		List<Departament> departaments = departamentService.findAll(null);
		for (Departament departament : departaments) {
			System.out.println(departament);
		}
	}
	
//	@Test
//	public void readAll_2() {
//		List<Departament> departaments = departamentService.findAll("part");
//		for (Departament departament : departaments) {
//			System.out.println(departament);
//		}
//	}
	
	@Test
	public void readById() {
		
		Long id = 1L;

		Departament departament = departamentService.findById(id);

		System.out.println(departament);
	}

	@Test
	public void create() {
		
		Departament departament = new Departament();
		departament.setId(null);
		departament.setName("Departamento de Física");

		departament = departamentService.create(departament);

		System.out.println(departament);
	}

	@Test
	public void update() {
		
		Departament departament = new Departament();
		departament.setId(null);
		departament.setName("Departameno de Biologia");
		
		departament = departamentService.update(departament);

		System.out.println(departament);
	}

	@Test
	public void deleteById() {
		
		Long id = 1L;

		departamentService.deleteById(id);
	}

	@Test
	public void deleteAll() {
		
		departamentService.deleteAll();
	}
	
	
}
