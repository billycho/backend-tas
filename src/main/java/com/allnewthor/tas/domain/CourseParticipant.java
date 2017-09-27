package com.allnewthor.tas.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="courseparticipant")
public class CourseParticipant implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="courseparticipantid")
	private int courseParticipantId;
	
	@ManyToOne
	@JoinColumn(name = "employeeid")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "courseid")
	private Course course;
	
	@Column(name="pass")
	private Boolean pass;
	
	public CourseParticipant() {
		super();
	}
	
//	public CourseParticipant(JSONObject obj) throws JSONException {
//		this.courseParticipantId = obj.getInt("courseParticipantId");
//		this.employee= new Employee(obj.getJSONObject("employee"));
//		this.course = new Course(obj.getJSONObject("course"));
//		
//	}
	public int getCourseParticipantId() {
		return courseParticipantId;
	}

	public void setCourseParticipantId(int courseParticipantId) {
		this.courseParticipantId = courseParticipantId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Boolean getPass() {
		return pass;
	}

	public void setPass(Boolean pass) {
		this.pass = pass;
	}
	
}
