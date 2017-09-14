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
	
	 private Integer GradeID;
	@Column(name="jobfamily")
	 private String JobFamily;
	@Column(name="grade")
	 private String Grade;
	 
	public Grade()
	{
		
	}
	 public Grade(String JobFamily, String Grade)
	 {
		 this.JobFamily = JobFamily;
		 this.Grade = Grade;
	 }
	 
	public Integer getGradeID() {
		return GradeID;
	}
	public void setGradeID(Integer gradeID) {
		GradeID = gradeID;
	}
	public String getJobFamily() {
		return JobFamily;
	}
	public void setJobFamily(String jobFamily) {
		JobFamily = jobFamily;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	 
	
}
