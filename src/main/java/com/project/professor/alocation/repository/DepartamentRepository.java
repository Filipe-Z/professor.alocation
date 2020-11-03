package com.project.professor.alocation.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.professor.alocation.model.Departament;


@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long> {

	List<Departament> findByNameContainingIgnoreCase(String name);
	
}
