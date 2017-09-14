package com.allnewthor.tas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/hello11")
	@ResponseBody
	public String hello()
	{
		return "Hello World";
	}
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public Iterable<Grade> getAll(Model model) {
		return gradeRepository.findAll();
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Grade getById(@PathVariable int id)
	{
		return gradeRepository.findOne(id);
	}
	
	
	
	
	
}
