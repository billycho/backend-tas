package com.allnewthor.tas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.allnewthor.tas.domain.Grade;

@Entity
@Table(name = "person_tbl1")
public class Person1 {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	 private int id;
	
	@Column(name="name")
	 private String name;
	 
	 @OneToOne
	 @JoinColumn(name="gradeid")
	 private Grade g;
	 
	 public Person1()
	 {
		 
	 }
	 
	 public Person1(String name)
	 {
		 this.name = name;
	 }
	 
	 public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade getGrade()
	 {
		 return this.g;
	 }
	 
	 public void setGrade(Grade grade)
	 {
		 this.g = grade;
	 }
	 
	 

}
