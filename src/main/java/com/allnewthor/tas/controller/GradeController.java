package com.allnewthor.tas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.Person;
import com.allnewthor.tas.PersonRepository;
import com.allnewthor.tas.domain.Grade;
import com.allnewthor.tas.domain.GradeRepository;

@RestController
@RequestMapping("/grades")
public class GradeController {
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello()
	{
		return "Hello World";
	}
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public Iterable<Grade> getAll(Model model) {
		return gradeRepository.findAll();
    }
	
	
	
	
	
}
