package com.allnewthor.tas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeData")
public class Employee {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer EmployeeID;
	 private String FullName;
	  
	 
}
