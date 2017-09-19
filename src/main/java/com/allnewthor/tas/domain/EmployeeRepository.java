package com.allnewthor.tas.domain;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends 
	JpaRepository<Employee, Integer>{
	
	Employee findByAccountName (String accountName);
	
}
