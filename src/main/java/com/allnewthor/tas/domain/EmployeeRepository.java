package com.allnewthor.tas.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends 
	JpaRepository<Employee, Integer>{
	
}
