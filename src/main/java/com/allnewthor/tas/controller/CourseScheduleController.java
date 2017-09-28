package com.allnewthor.tas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.CourseSchedule;
import com.allnewthor.tas.domain.CourseScheduleRepository;

@RestController
@RequestMapping("/schedules")
public class CourseScheduleController {
	@Autowired
	private CourseScheduleRepository courseScheduleRepository;
	
	@GetMapping(value="")
	public List<CourseSchedule> getAll(Model model){
		return courseScheduleRepository.findAll();
	}
	
}
