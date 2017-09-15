package com.allnewthor.tas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.TasUser;
import com.allnewthor.tas.domain.TasUserRepository;

@RestController
@RequestMapping("/users")
public class TasUserController {
	@Autowired
	private TasUserRepository tasUserRepository;
	
	//HowToCall:http://localhost:8080/users/all?page=0&size=10&sort=fullname
	@GetMapping(value="")
	public Page<TasUser> getAll(Pageable pageable){
		return tasUserRepository.findAll(pageable);
	}
	
	@GetMapping(value="/all")
	public Iterable<TasUser> getAll(){
		return tasUserRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public TasUser getById(@PathVariable("id") Integer id) {
		return tasUserRepository.findOne(id);
	}
	
	@PostMapping(value = "/load") 
	public TasUser load(@RequestBody final TasUser tasUser){
		tasUserRepository.save(tasUser);
		return tasUserRepository.findOne(tasUser.getTasUserId());
	}
}
