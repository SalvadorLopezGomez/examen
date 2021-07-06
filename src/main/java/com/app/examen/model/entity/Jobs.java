package com.app.examen.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class Jobs implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1878260501632118099L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_job")
	private Long idJob;
	
	private String name;
	private float salary;
	
	@OneToMany(mappedBy = "idJob", fetch = FetchType.EAGER)
	private Set<Employees> employees;

	public Long getIdJob() {
		return idJob;
	}

	public void setIdJob(Long idJob) {
		this.idJob = idJob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
}
