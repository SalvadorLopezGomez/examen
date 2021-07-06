package com.app.examen.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.examen.components.EmployeeResponse;
import com.app.examen.model.entity.Employees;
import com.app.examen.model.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employees> getEmployees() {
		return employeeService.getEmployees();
		
	}
	
	@GetMapping()
	public ResponseEntity<String> getByJob(String puesto){
		return employeeService.getJobsEmployees(puesto);
	} 
	
	@PostMapping("/employees/new")
	public Employees createEmployee(@Validated @RequestBody(required = true) EmployeeResponse employee) {
		Employees employees = employeeService.createEmployees(employee);
		return employees;
	}
}
