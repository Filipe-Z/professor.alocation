package com.project.professor.alocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.alocation.model.Allocation;
import com.project.professor.alocation.model.Departament;
import com.project.professor.alocation.model.Professor;
import com.project.professor.alocation.repository.AllocationRepository;
import com.project.professor.alocation.repository.CourseRepository;
import com.project.professor.alocation.repository.ProfessorRepository;

@Service
public class AllocationService {

//	private ProfessorRepository professorRepository;
//	private CourseRepository courseRepository;
	private AllocationRepository allocationRepository;
	
	public AllocationService(AllocationRepository allocationRepository) {
		super();
		this.allocationRepository = allocationRepository;
	}
	
	public List<Allocation> findAll(Long id){
		if (id == null) {
		return allocationRepository.findAll();
		} else {
		return allocationRepository.findByNameContainingIgnoreCase(id);
		}
	}
	
//	public Allocation findById(Long id) {
//		return allocationRepository.findById(id).orElse(null);
//	}
//	
//	public Allocation create(Allocation allocation) {
//		allocation.setId(null);
//		
//		allocation = allocationRepository.save(allocation);
//		
//		Long professorId = allocation.getProfessor().getId();
//		Departament departament = professorService.findById(professorId);
//		allocation.setprofessor(departament);
//		return allocation;
//	}
	
	public Allocation update(Allocation allocation) {
		return allocationRepository.save(allocation);
	}
	
	public void deleteById(Long id) {
		if (allocationRepository.existsById(id)) {
			allocationRepository.deleteById(id);	
		}
	}
	
	public void deleteAll() {
		allocationRepository.deleteAllInBatch();
    }
	
	
	
}
