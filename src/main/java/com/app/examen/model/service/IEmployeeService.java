package com.app.examen.model.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.examen.components.EmployeeResponse;
import com.app.examen.model.entity.Employees;

public interface IEmployeeService {

	List<Employees> getEmployees();
	Employees createEmployees(EmployeeResponse employee);
	ResponseEntity<String> getJobsEmployees(String puesto);
}
