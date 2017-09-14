package com.allnewthor.tas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.Location;
import com.allnewthor.tas.domain.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationController {
	@Autowired
	private LocationRepository locationRepository;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public Iterable<Location> getAll(Model model) {
		return locationRepository.findAll();
    }
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Location getById(@PathVariable(value="id") Integer id) {
		return locationRepository.findOne(id);
    }
}
