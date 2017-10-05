package com.allnewthor.tas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.allnewthor.tas.domain.CourseParticipant;
import com.allnewthor.tas.domain.CourseParticipantRepository;
import com.allnewthor.tas.domain.ExportAchievement;

@Controller
@RequestMapping("/downloads")
public class ExportAchievementController {
	@Autowired
	private CourseParticipantRepository courseParticipantRepository;
	
       @GetMapping(value="/achievement")
       public ModelAndView getExcel(){
    	   List<CourseParticipant> courseParticipantList= courseParticipantRepository.findAll();
              return new ModelAndView(new ExportAchievement(),"courseParticipantList",courseParticipantList);
       }
}