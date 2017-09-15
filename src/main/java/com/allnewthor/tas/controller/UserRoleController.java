package com.allnewthor.tas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.UserRole;
import com.allnewthor.tas.domain.UserRoleRepository;

@RestController
@RequestMapping("/users")
public class UserRoleController {
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@GetMapping(value="")
	public Iterable<UserRole> getAll(Model model){
		return userRoleRepository.findAll();
	}
	
//	@PostMapping(value = "/load") 
//	public UserRole load(@RequestBody final UserRole userRole){
//		userRoleRepository.save(userRole);
//		return userRoleRepository.findOne(userRole.getUserRoleId());
//	}
}
