package com.allnewthor.tas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coursename")
public class CourseName {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="coursenameid")
	private Integer coursenameid;
	
	@Column(name="coursename")
	private String coursename;
	
	@Column(name="coursetype")
	private String coursetype;
	
	@Column( name="courselevel")
	private Integer courselevel;

	public Integer getCoursenameid() {
		return coursenameid;
	}

	public void setCoursenameid(Integer coursenameid) {
		this.coursenameid = coursenameid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}

	public Integer getCourselevel() {
		return courselevel;
	}

	public void setCourselevel(Integer courselevel) {
		this.courselevel = courselevel;
	}
	
	
	
	
	
	
	
	 
}
