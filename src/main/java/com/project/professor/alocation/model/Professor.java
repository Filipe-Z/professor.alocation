package com.project.professor.alocation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Professor")
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name ="cpf", nullable = false)
	private String cpf;
	@Column(name ="name", nullable = false)
	private String name;
	
@JsonIgnoreProperties({"professors"})
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Departament departament;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
	private List<Allocation> allocation;
	
	public Professor() {
		super();
	}

	public Professor(Long id, String cpf, String name) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartament(Departament departament2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", cpf=" + cpf + ", name=" + name + "]";
	}

	public Professor getDepartament() {
		// TODO Auto-generated method stub
		return null;
	}
}
