package com.emp.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.repo.EmployeeRepo;

@RestController("/")
public class EmployeeRest {

	@Autowired EmployeeRepo repo;
	
	@RequestMapping(value="/employees", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void saveEmployees(@RequestBody List<Employee> employees) {
		repo.save(employees);
	}
}
