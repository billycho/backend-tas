package com.allnewthor.tas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "courseschedule")
public class CourseSchedule {
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO )
	@Column(name = "coursescheduleid")
	private Integer courseScheduleId;
	
	@ManyToOne
	@JoinColumn(name="courseid")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name="roomid")
	private Room room;
	
	@Column(name="date")
	private String date;
	
	@Column(name="starttime")
	private String startTime;
	
	@Column(name="endtime")
	private String endTime;

	public Integer getCourseScheduleId() {
		return courseScheduleId;
	}

	public void setCourseScheduleId(Integer courseScheduleId) {
		this.courseScheduleId = courseScheduleId;
	}

	@JsonIgnore
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}


	public void String(String endTime) {
		this.endTime = endTime;
	}
	
}
