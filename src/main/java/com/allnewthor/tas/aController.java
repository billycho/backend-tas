package com.allnewthor.tas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allnewthor.tas.domain.Grade;
import com.allnewthor.tas.domain.GradeRepository;

@Controller
public class aController {

	@Autowired
	Person1Repository person1Repository;
	
	@Autowired
	GradeRepository gradeRepository;
	
	@RequestMapping("/asda1111")
	@ResponseBody
	public String aController()
	{
		
		Person1 new_person = new Person1("asda");
		Grade grade = gradeRepository.findOne(2);
		new_person.setGrade(grade);
		person1Repository.save(new_person);
		return new_person.getId().toString();
	}
}
