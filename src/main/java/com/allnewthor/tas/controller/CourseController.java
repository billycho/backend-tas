package com.allnewthor.tas.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.Course;
import com.allnewthor.tas.domain.CourseName;
import com.allnewthor.tas.domain.CourseNameRepository;
import com.allnewthor.tas.domain.CourseParticipant;
import com.allnewthor.tas.domain.CourseRepository;
import com.allnewthor.tas.domain.Employee;
import com.allnewthor.tas.domain.EmployeeRepository;
import com.allnewthor.tas.domain.TrainingPeriod;
import com.allnewthor.tas.domain.TrainingPeriodRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private TrainingPeriodRepository trainingPeriodRepository;
	
	@Autowired
	private CourseNameRepository courseNameRepository;

	@GetMapping(value="")
	public List<Course> getAll(Model model){
		return courseRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Course getById(@PathVariable("id")Integer id){
		return courseRepository.findOne(id);
	}
	@GetMapping(value = "/{id}/participants")
	public List<CourseParticipant> getParticipant(
			@PathVariable("id")Integer id
			) {

		return courseRepository.findOne(id).getCourseParticipant();
	}
	@PostMapping(value="/create")
	public Course create(
			@RequestBody String body
			) throws JSONException
		{ 	
		JSONObject obj = new JSONObject(body);
		
		Course course = new Course();
		
		CourseName coursename = new CourseName();
		TrainingPeriod trainingPeriod = new TrainingPeriod();
		Employee mainTrainer = new Employee();
		Employee backUpTrainer = new Employee();
		Integer capacity;
		
		coursename = this.courseNameRepository.findOne(obj.getInt("coursenameid"));
		trainingPeriod =this.trainingPeriodRepository.findOne(obj.getInt("trainingPeriodId"));
		mainTrainer = this.employeeRepository.findOne(obj.getInt("mainTrainerId"));
		
		if(obj.has("backUpTrainerId")) {
			backUpTrainer = this.employeeRepository.findOne(obj.getInt("backUpTrainerId"));
			course.setBackUpTrainer(backUpTrainer);
		}
		
		capacity = obj.getInt("capacity");
		
		
		course.setCoursename(coursename);
		course.setTrainingPeriod(trainingPeriod);
		course.setMainTrainer(mainTrainer);
		
		course.setCapacity(capacity);
		
		this.courseRepository.save(course);
		return this.courseRepository.findOne(course.getCourseId());
		}

	@PostMapping(value="/{id}/addparticipant")
	public Employee addParticipant(
			@PathVariable("id")Integer id,
			@RequestBody String body
			) throws JSONException
		{ 	
		JSONObject obj = new JSONObject(body);
		
		Employee participant = new Employee();
		participant = this.employeeRepository.findOne(obj.getInt("employeeId")); 
		Boolean pass = obj.getBoolean("pass");
		
		Course course = new Course();
		course = this.courseRepository.findOne(id);
		
		
		CourseParticipant cp = new CourseParticipant();
		cp.setCourse(course);
		cp.setEmployee(participant);
		cp.setPass(pass);
		
		course.addCourseParticipant(cp);
		
		this.courseRepository.save(course);
		this.employeeRepository.save(participant);
		
		return this.employeeRepository.findOne(participant.getEmployeeId());
		}
}