package com.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.employee.model.Employee;

@Service
public class EmployeeService{
	
	List<Employee> list=new ArrayList();
	
	Employee emp1=new Employee(1,"sri",20,"developer");
	Employee emp2=new Employee(2,"prasanth",21,"tester");
	
	
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		return list;
	}

	public Employee findById(Long id) {
		// TODO Auto-generated method stub
		int n=list.size();
		
		Employee emp=list.stream().filter(e->e.getId()==(id)).findAny().orElse(null);
		
		return emp;
	}

	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		System.out.println("at service");
		list.add(emp);
		return emp;
	}

	public void testrun() {
		// TODO Auto-generated method stub
		list.add(emp1);
		list.add(emp2);	
	}

	

}
