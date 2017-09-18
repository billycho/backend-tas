package com.allnewthor.tas.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.Employee;
import com.allnewthor.tas.domain.EmployeeRepository;
import com.allnewthor.tas.domain.Role;
import com.allnewthor.tas.domain.RoleRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping(value="all")
	public Iterable<Employee> getAll(Model model){
		return employeeRepository.findAll();
	}
	
	@GetMapping(value="")
	public Page<Employee> getAll(Pageable pageable){
		return employeeRepository.findAll(pageable);
	}
	
	@GetMapping (value ="/{id}")
	public Employee getById(@PathVariable("id") Integer id){
		return employeeRepository.findOne(id);
	}
	
	@PostMapping (value = "/addrole")
	public Employee postRole(
			@RequestBody Map<String,String> tasuser
			) { 
		Integer employee_id = Integer.parseInt(tasuser.get("employeeId"));
		Integer role_id = Integer.parseInt(tasuser.get("roleId"));
		
		Employee employee = new Employee();
		employee = employeeRepository.findOne(employee_id);
	
		Role role = new Role();
		role = roleRepository.findOne(role_id);
		Set<Role> roles = employee.getRoles();
		roles.add(role);
		
		employee.setRoles(roles);
		
		employeeRepository.save(employee);
		
		return employeeRepository.findOne(employee.getEmployeeId());
	}
}
