package com.allnewthor.tas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Grade")
public class Grade {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="gradeid")
	 private Integer gradeid;
	 
	@Column(name="jobfamily")
	 private String jobfamily;
	@Column(name="grade")
	 private String grade;
	 
	public Integer getGradeid() {
		return gradeid;
	}
	public void setGradeid(Integer gradeid) {
		this.gradeid = gradeid;
	}
	public String getJobfamily() {
		return jobfamily;
	}
	public void setJobfamily(String jobfamily) {
		this.jobfamily = jobfamily;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	 
	 
	
}
