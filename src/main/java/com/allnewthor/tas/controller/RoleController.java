package com.allnewthor.tas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.Employee;
import com.allnewthor.tas.domain.Role;
import com.allnewthor.tas.domain.RoleRepository;

@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public Iterable<Role> getAll(Model model) {
		return roleRepository.findAll();
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Role getById(@PathVariable int id)
	{
		return roleRepository.findOne(id);
	}
	
	@RequestMapping(value = "/{id}/employees", method = RequestMethod.GET)
	public List<Employee> getEmployeesByRole(@PathVariable int id)
	{
		return roleRepository.findOne(id).getEmployees();
	}
}
