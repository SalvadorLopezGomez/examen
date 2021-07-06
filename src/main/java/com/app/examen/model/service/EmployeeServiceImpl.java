package com.app.examen.model.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.examen.components.EmployeeResponse;
import com.app.examen.model.dao.EmployeeDao;
import com.app.examen.model.dao.GendersDao;
import com.app.examen.model.dao.JobsDao;
import com.app.examen.model.entity.Employees;
import com.app.examen.model.entity.Genders;
import com.app.examen.model.entity.Jobs;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private GendersDao genderDao;
	
	@Autowired
	private JobsDao jobDao;
	
	@Override
	public List<Employees> getEmployees() {
		return (List<Employees>) employeeDao.findAll();
	}

	@Override
	public Employees createEmployees(EmployeeResponse body) {
		Employees employee = new Employees();
		Optional<Genders> getGenders = genderDao.findById((long) body.getId_genero());
		if(getGenders.isPresent()) {
			employee.setId_gender(getGenders.get());
		}
		
		Optional<Jobs> getJobs = jobDao.findById((long) body.getId_trabajo());
		if(getJobs.isPresent()) {
			employee.setId_job(getJobs.get());
		}
		
		employee.setName(body.getName());
		employee.setLastName(body.getLastName());
		employee.setBirthday(body.getBirthday());
		
		Period edad = Period.between(employee.getBirthday().toLocalDate(), LocalDate.now());
		
		if(edad.getYears() >= 18) {
			return employeeDao.save(employee);
		}else {
			throw new IllegalArgumentException("Edad no permitida, debe ser mayor de edad");
		}
	}

	@Override
	public ResponseEntity<String> getJobsEmployees(String puesto) {
		ResponseEntity<String> data = employeeDao.findByJob();
		return data;
	}
}
