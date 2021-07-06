package com.app.examen.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import com.app.examen.model.entity.Employees;

public interface EmployeeDao extends CrudRepository<Employees, Long>{

	@Query(value = "SELECT e.name, e.last_name, j.name, j.salary FROM employees e INNER JOIN jobs j ON e.id  = j.id_job", nativeQuery = true)
	ResponseEntity<String> findByJob();
}
