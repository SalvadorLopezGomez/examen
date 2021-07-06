package com.app.examen.model.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "employees")
public class Employees implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3347687351809473776L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idEmployee;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_gender", nullable = false)
	private Genders idGenders;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_job")
	private Jobs idJob;
	
	@Column(unique = true)
	private String name;
	
	@Column(unique = true)
	private String lastName;
	
	@NotNull(message = "La fecha no puede ser Nulo")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;
	
	@OneToMany(mappedBy = "idEmployee", fetch = FetchType.EAGER)
	private Set<Employee_worked_hours> employees_workhrs;

	public Long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}

	public Genders getId_gender() {
		return idGenders;
	}

	public void setId_gender(Genders idGenders) {
		this.idGenders = idGenders;
	}

	public Jobs getId_job() {
		return idJob;
	}

	public void setId_job(Jobs idJob) {
		this.idJob = idJob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
