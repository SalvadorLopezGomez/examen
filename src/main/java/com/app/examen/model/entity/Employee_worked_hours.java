package com.app.examen.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "employee_worked_hours")
public class Employee_worked_hours implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6133125402433871034L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_workedhrs")
	private Long idWorkedHours;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id", nullable = false)
	private Employees idEmployee;
	
	@Column(name = "worked_hours")
	private int hours;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "worked_date")
	private Date date;

	public Long getIdWorkedHours() {
		return idWorkedHours;
	}

	public void setIdWorkedHours(Long idWorkedHours) {
		this.idWorkedHours = idWorkedHours;
	}

	public Employees getId_employee() {
		return idEmployee;
	}

	public void setId_employee(Employees idEmployee) {
		this.idEmployee = idEmployee;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
