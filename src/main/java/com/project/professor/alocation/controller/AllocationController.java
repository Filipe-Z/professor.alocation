package com.project.professor.alocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.professor.alocation.model.Allocation;
import com.project.professor.alocation.service.AllocationService;



@RestController
@RequestMapping(path = "/allocation", produces = MediaType.APPLICATION_JSON_VALUE)
public class AllocationController {

	private AllocationService allocationService;

	public AllocationController(AllocationService allocationService) {
		super();
		this.allocationService = allocationService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Allocation>> getAllocations() {
		List<Allocation> allocations = allocationService.findAll();
		return new ResponseEntity<>(allocations, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Allocation> getAllocation(@PathVariable(value = "id") Long id) {
		Allocation allocation = allocationService.findById(id);
		if (allocation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(allocation, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/professor/{professor_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Allocation>> getAllocationsByProfessor(@PathVariable(value = "professor_id") Long id) {
		List<Allocation> allocations = allocationService.findByProfessor(id);
		return new ResponseEntity<>(allocations, HttpStatus.OK);
	}

	@GetMapping(value = "/course/{course_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Allocation>> getAllocationsByCourse(@PathVariable(value = "course_id") Long id) {
		List<Allocation> allocations = allocationService.findByCourse(id);
		return new ResponseEntity<>(allocations, HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Allocation> createAllocation(@RequestBody Allocation allocation) {
		allocation = allocationService.create(allocation);
		if (allocation == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(allocation, HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Allocation> updateAllocation(@PathVariable(value = "id") Long id,
			@RequestBody Allocation allocation) {
		allocation.setId(id);
		allocation = allocationService.update(allocation);
		if (allocation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(allocation, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAllocation(@PathVariable(value = "id") Long id) {
		allocationService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAllocations() {
		allocationService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
