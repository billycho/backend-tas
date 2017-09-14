package com.allnewthor.tas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.CourseName;
import com.allnewthor.tas.domain.CourseNameRepository;
import com.allnewthor.tas.domain.Grade;

@RestController
@RequestMapping("/coursenames")
public class CourseNameController {
	@Autowired
	private CourseNameRepository courseNameRepository;
	
	
	@GetMapping(value="")
	public Iterable<CourseName> getAll(Model model) {
		return courseNameRepository.findAll();
    }
	
	@GetMapping(value = "/{id}")
	public CourseName getById(@PathVariable int id)
	{
		return courseNameRepository.findOne(id);
	}
	
}
