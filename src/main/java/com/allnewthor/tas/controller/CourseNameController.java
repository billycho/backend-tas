package com.allnewthor.tas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.CourseName;
import com.allnewthor.tas.domain.CourseNameRepository;

@RestController
@RequestMapping("/coursenames")
public class CourseNameController {
	@Autowired
	private CourseNameRepository courseNameRepository;
	
	
//	http://localhost:8080/coursenames/all?page=0&size=3&sort=coursename
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	Iterable<CourseName> courseNamesPageable(Pageable pageable)
	{
		return courseNameRepository.findAll();
	}
	
	@RequestMapping(value="", method = RequestMethod.GET)
	List<CourseName> courseNamesPageable(Model model)
	{
		return courseNameRepository.findAll();
	}
		
	
	@GetMapping(value = "/{id}")
	public CourseName getById(@PathVariable int id)
	{
		return courseNameRepository.findOne(id);
	}
	
	@GetMapping(value ="/bcc")
	public List<CourseName> getBCCCourseNames(Model model) {
		return courseNameRepository.findByCoursetype("BCC");
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
	
	@PostMapping(value = "/update")
	public void update(@RequestBody final CourseName updatedcoursename)
	{
		System.out.println(updatedcoursename.getCoursename());
		CourseName coursename = courseNameRepository.findOne(updatedcoursename.getCoursenameid());
		coursename.setCoursename(updatedcoursename.getCoursename());
		coursename.setCoursetype(updatedcoursename.getCoursetype());
		coursename.setCourselevel(updatedcoursename.getCourselevel());
		
		courseNameRepository.save(coursename); 
		
	}
	
//	@PostMapping(value="update")
//	public void update()
//	{
//		CourseName courseName = courseNameRepository.findOne(16);
//		courseName.setCoursename("asda");
//		courseName.setCourselevel(12);
//		courseName.setCoursetype("asda");
//		
//	}
	
	
	
	
	
	
}
