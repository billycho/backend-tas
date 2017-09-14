package com.allnewthor.tas;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	//Person findByName(String name);
}