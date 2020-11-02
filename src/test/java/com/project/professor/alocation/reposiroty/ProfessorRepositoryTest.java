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
import com.project.professor.alocation.model.Professor;
import com.project.professor.alocation.repository.ProfessorRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorRepositoryTest {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Test
	public void create() { 
		//Arrange
		
		Departament departament = new Departament();
		departament.setId(2L);
		
		Professor professor = new Professor();
		professor.setId(null);
		professor.setName("Professor 1");
		professor.setCpf("111.111.111-11");
		//professor.setDepartament(departament);
		
		professor = professorRepository.save(professor);
		
		System.out.println(professor);
	}
	
	public Professor create(Professor professor) {
	return professorRepository.save(professor);
	}
	
	@Test
	public void readAll() {          //ERRO
		List<Professor> professors = professorRepository.findAll(); 
		
		for (Professor professor : professors) {
			System.out.println(professor.toString());
		}
	}
	
	@Test
	public void readById() {        //ERRO
		Long id = 1L;
		Optional<Professor> optionalProfessor = professorRepository.findById(id);
		Professor professor = optionalProfessor.orElse(null);
		System.out.println(professor);
	}
	
	@Test 
	public void update() {
		Professor professor = new Professor();
	    professor.setId(null);
		professor.setName("Professor 1");
		professor.setCpf("111.111.111-11");
		professor = professorRepository.save(professor);
	
	    System.out.println(professor);	
	}
	
}
