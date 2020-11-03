package com.project.professor.alocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.alocation.model.Departament;
import com.project.professor.alocation.repository.DepartamentRepository;

@Service
public class DepartamentService {

	private DepartamentRepository departamentRepository;

	public DepartamentService(DepartamentRepository departamentRepository) {
		super();
		this.departamentRepository = departamentRepository;
	}
	
	public List<Departament> findAll(String name){
		if (name == null) {
		return departamentRepository.findAll();
		} else {
		return departamentRepository.findByNameContainingIgnoreCase(name);
		}
	}
	
	public Departament findById(Long id) {
		return departamentRepository.findById(id).orElse(null);
	}
	
	public Departament create (Departament departament){
		departament.setId(null);
		return departamentRepository.save(departament);
	}
	
	public Departament update(Departament departament) {
		return departamentRepository.save(departament);
	}
	
	public void deleteById(Long id) {
		if (departamentRepository.existsById(id)) {
			departamentRepository.deleteById(id);	
		}
	}
	
	//1 outra forma
//	public void deleteById(Long id) {
//	if (findById(id) != null) {
//		departamentRepository.deleteById(id);
//	}
//}
	
	//2 outra forma
//	try {
//		departamentRepository.deleteById(id);
//	} catch (EmpytResultDataAccessException e){
//		e.printStackTrace();
//	}

	public void deleteAll() {
		departamentRepository.deleteAllInBatch();
    }
	
}