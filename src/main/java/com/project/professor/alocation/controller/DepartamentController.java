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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.professor.alocation.model.Departament;
import com.project.professor.alocation.service.DepartamentService;

@RestController
@RequestMapping(path = "/departament", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartamentController {

	private DepartamentService departamentService;
	
	public DepartamentController(DepartamentService departamentService) {
		super();
		this.departamentService = departamentService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Departament>> readAll(@RequestParam(name = "name", required = false) String name){
		List<Departament> departaments = departamentService.findAll(name);
		return new ResponseEntity<List<Departament>>(departaments, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)      //readById
	public ResponseEntity<Departament> getDepartament(@PathVariable(value = "id") Long id) {
		Departament departament = departamentService.findById(id);
		if (departament == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(departament, HttpStatus.OK);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)  //created
	public ResponseEntity<Departament> createDepartament(@RequestBody Departament departament) {
		departament = departamentService.create(departament);
		if (departament == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(departament, HttpStatus.CREATED);
		}
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)      //update - PUT
	public ResponseEntity<Departament> update(@PathVariable(value = "id") Long id,
			@RequestBody Departament departament) {
		departament.setId(id);
		departament = departamentService.update(departament);
		if (departament == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(departament, HttpStatus.CREATED);
		}
	}

//	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseStatus(HttpStatus.OK)      //update - PUT
//	public ResponseEntity<Departament> updateDepartament(@PathVariable(value = "id") Long id,
//			@RequestBody Departament departament) {
//		departament.setId(id);
//		departament = departamentService.update(departament);
//		if (departament == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} else {
//			return new ResponseEntity<>(departament, HttpStatus.OK);
//		}
//	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
		departamentService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAll() {
		departamentService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
