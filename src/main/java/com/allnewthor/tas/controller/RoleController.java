package com.allnewthor.tas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.Role;
import com.allnewthor.tas.domain.RoleRepository;

@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello()
	{
		return "Hello World";
	}
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public Iterable<Role> getAll(Model model) {
		return roleRepository.findAll();
    }
}
