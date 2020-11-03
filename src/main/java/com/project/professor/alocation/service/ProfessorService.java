package com.project.professor.alocation.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.project.professor.alocation.model.Departament;
import com.project.professor.alocation.model.Professor;
import com.project.professor.alocation.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private DepartamentService departamentService;
	private ProfessorRepository professorRepository;
	
	public ProfessorService(ProfessorRepository professorRepository) {
		super();
		this.professorRepository = professorRepository;
	}
	
	public List<Professor> findAll(String name){
		if (name == null) {
		return professorRepository.findAll();
		} else {
		return professorRepository.findByNameContainingIgnoreCase(name);
		}
	}
	
	public Professor findById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}
	
	public Professor create(Professor professor) {
		professor.setId(null);
		
		professor = professorRepository.save(professor);
		
		Long departamentId = professor.getDepartament().getId();
		Departament departament = departamentService.findById(departamentId);
		professor.setDepartament(departament);
		return professor;
	}
	
	public Professor update(Professor professor) {
		return professorRepository.save(professor);
	}
	
	public void deleteById(Long id) {
		if (professorRepository.existsById(id)) {
			professorRepository.deleteById(id);	
		}
	}
	
	public void deleteAll() {
		professorRepository.deleteAllInBatch();
    }
	
	
	
	
}
