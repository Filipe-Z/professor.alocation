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

import com.project.professor.alocation.model.Departament;
import com.project.professor.alocation.repository.DepartamentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartamentRepositoryTest {

	@Autowired
	private DepartamentRepository departamentRepository;
	
	@Test
	public void readAll() {          //ERRO
		List<Departament> departaments = departamentRepository.findAll(); 
		
		for (Departament departament : departaments) {
			System.out.println(departament);
		}
	}
	
	@Test
	public void readById() {
		Long id = 1L;
		Optional<Departament> optionalDepartament = departamentRepository.findById(id);
		Departament departament = optionalDepartament.orElse(null);
		System.out.println(departament);
	}
	
	@Test
	public void create() {
		Departament departament = new Departament();
		departament.setId(null);
		departament.setName("Departamento de ti");
		
		Departament departament2 = departamentRepository.save(departament);
		System.out.println(departament2);
	}
	
//	public Departament create (Departament departament) {
//	departament.setId(null);
//	Departament departament2 = departamentRepository.save(departament);	
//	return departament2;
//	}
	
	@Test
	public void update() {
		Departament departament = new Departament();
		departament.setId(null);
		departament.setName("Departamento de Teste");
		
		Departament departament2 = departamentRepository.save(departament);
		System.out.println(departament2);
	}
	
	@Test
	public void deleteAll() {
	departamentRepository.deleteAllInBatch();
	}
	
	@Test
	public void deleteById() {
		Long id = 1L;
	departamentRepository.deleteById(id);
	}
}
