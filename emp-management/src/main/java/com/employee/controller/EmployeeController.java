package com.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;



@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeservice;
	
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class.getName());

	
	@RequestMapping("/test")
	public String Test() {
		
		employeeservice.testrun();
		LOG.info("DummyObject added sucessfully");
		return("working");
	}

	@GetMapping("/get")
	public List<Employee> getAll() {
		
		List <Employee> emplist=employeeservice.findAll();
	    LOG.info("getAll "+emplist);
		return emplist;
	}
	
	
	@GetMapping("/get/{id}")
	public Employee findById(@PathVariable Long id) {
		
		Employee e= employeeservice.findById(id);
		LOG.info("get By Id"+e);
		return e;
	}
	
	@PostMapping("/add")
	public Employee addAll(@RequestBody Employee emp)
	{
		
		System.out.println("at controller"+emp);
		Employee empl=employeeservice.save(emp);
		LOG.info("add "+empl);
		
		return empl;
		
	}


//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<Employee> delete(@PathVariable Long id) {
//		employeeservice.deleteById(id)
//		return ResponseEntity.ok().build();
//	}
	

}
