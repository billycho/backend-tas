package com.allnewthor.tas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.allnewthor.tas.domain.CourseName;
import com.allnewthor.tas.domain.CourseNameRepository;

@RestController
@RequestMapping("/coursenames")
public class CourseNameController {
	@Autowired
	private CourseNameRepository courseNameRepository;
	
	
//	http://localhost:8080/coursenames/all?page=0&size=3&sort=coursename
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	Page<CourseName> courseNamesPageable(Pageable pageable)
	{
		return courseNameRepository.findAll(pageable);
	}
		
	
	@GetMapping(value = "/{id}")
	public CourseName getById(@PathVariable int id)
	{
		return courseNameRepository.findOne(id);
	}
	
	@PostMapping(value="/create")
	public void create(@RequestBody final CourseName courseName)
	{
		courseNameRepository.save(courseName);
	}
	
	
	@GetMapping(value = "/{id}/delete")
	public void delete(@PathVariable int id)
	{
		courseNameRepository.delete(id);
	}
	
	
	
	
}
