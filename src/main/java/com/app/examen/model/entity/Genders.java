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
@Table(name = "genders")
public class Genders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7721104379240971480L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gender")
	private Long idGender;
	
	private String name;
	
	@OneToMany(mappedBy = "idGenders", fetch = FetchType.EAGER)
	private Set<Employees> employees;

	public Long getIdGender() {
		return idGender;
	}

	public void setIdGender(Long idGender) {
		this.idGender = idGender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
