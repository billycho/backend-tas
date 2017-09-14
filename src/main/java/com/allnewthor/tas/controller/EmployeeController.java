package com.allnewthor.tas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.Employee;
import com.allnewthor.tas.domain.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping(value="")
	public Iterable<Employee> getAll(Model model){
		return employeeRepository.findAll();
	}
	
	@GetMapping (value ="/{id}")
	public Employee getById(@PathVariable("id") Integer id){
		return employeeRepository.findOne(id);
	}
}
