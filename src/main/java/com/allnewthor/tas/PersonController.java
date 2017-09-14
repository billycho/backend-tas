package com.allnewthor.tas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping("/boot")
	public Iterable<Person> boot()
	{
		
		Person a = new Person("ab1x");
		Person b = new Person("ccc");
		
		List<Person> asda = new ArrayList<Person>();
		asda.add(a);
		asda.add(b);
		
      personRepository.save(a);
      personRepository.save(b);
		
		System.out.println("13578111111");
		return personRepository.findAll();
	}

//	
//	@RequestMapping("/boot")
//	public Iterable<Person> boot()
//	{
//		Person user1= new Person(10,"Alice");
//        Person user2= new Person(11, "Bob");
//        

//        
//		return  personRepository.findAll();
//	}
}
