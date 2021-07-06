package com.app.examen.components;

import java.sql.Date;

public class EmployeeResponse {

	private Long id;
	private int id_genero;
	private int id_trabajo;
	private String name;
	private String lastName;
	private Date birthday;
	
	public EmployeeResponse(Long id, int id_genero, int id_trabajo, String name, String lastName, Date birthday) {
		this.id = id;
		this.id_genero = id_genero;
		this.id_trabajo = id_trabajo;
		this.name = name;
		this.lastName = lastName;
		this.birthday = birthday;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getId_genero() {
		return id_genero;
	}
	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}
	public int getId_trabajo() {
		return id_trabajo;
	}
	public void setId_trabajo(int id_trabajo) {
		this.id_trabajo = id_trabajo;
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

	@Override
	public String toString() {
		return "EmployeeResponse [id=" + id + ", id_genero=" + id_genero + ", id_trabajo=" + id_trabajo + ", name="
				+ name + ", lastName=" + lastName + ", birthday=" + birthday + "]";
	}
	
}
