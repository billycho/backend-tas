package com.allnewthor.tas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.Room;
import com.allnewthor.tas.domain.RoomRepository;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	@Autowired
	private RoomRepository roomRepository;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public Iterable<Room> getAll(Model model) {
		return roomRepository.findAll();
    }
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Room getById(@PathVariable("id") Integer id) {
		return roomRepository.findOne(id);
	}
}
