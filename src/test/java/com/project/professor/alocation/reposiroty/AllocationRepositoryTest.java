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

import com.project.professor.alocation.model.Allocation;
import com.project.professor.alocation.model.Departament;
import com.project.professor.alocation.repository.AllocationRepository;
import com.project.professor.alocation.repository.DepartamentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTest {

	@Autowired
	private AllocationRepository allocationRepository;
	
	@Test
	public void findAll() {          //ERRO
		List<Allocation> allocations = allocationRepository.findAll(); 
		allocations.stream().forEach(System.out::println);
//		for (Allocation allocation : allocations) {
//			System.out.println(allocation);
//		}
	}
	
	@Test
	public void findById() {
		Long id = 1L;
		Optional<Allocation> optionalAllocation = allocationRepository.findById(id);
		Allocation allocation = optionalAllocation.orElse(null);
		System.out.println(allocation);
	}
	
	@Test
	public void create() {
		Allocation allocation = new Allocation();
		allocation.setId(null);
		allocation.setDay(null);
		allocation.setEnd(null);
		allocation.setStart(null);
		
		Allocation allocations = allocationRepository.save(allocation);
		System.out.println(allocation);
	}
	
	@Test
	public void update() {
		Allocation allocation = new Allocation();
		allocation.setId(null);
		allocation.setDay(null);
		allocation.setEnd(null);
		allocation.setStart(null);
		
		Allocation allocations = allocationRepository.save(allocation);
		System.out.println(allocation);
	}
	
	@Test
	public void deleteAll() {
		allocationRepository.deleteAllInBatch();
	}
	
	@Test
	public void deleteById() {
		Long id = 1L;
		allocationRepository.deleteById(id);
	}
}
