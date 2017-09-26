package com.allnewthor.tas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.TrainingPeriod;
import com.allnewthor.tas.domain.TrainingPeriodRepository;

@RestController
@RequestMapping("/periods")
public class TrainingPeriodController {
	@Autowired
	private TrainingPeriodRepository periodRepository;
	
	@GetMapping(value="")
	public List<TrainingPeriod> getAll(Model model){
		return periodRepository.findAll();
	}
	
	
	
}
