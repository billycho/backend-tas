package com.allnewthor.tas.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private LocalDate date;
	
	@Column(name="starttime")
	private LocalTime startTime;
	
	@Column(name="endtime")
	private LocalTime endTime;

	public Integer getCourseScheduleId() {
		return courseScheduleId;
	}

	public void setCourseScheduleId(Integer courseScheduleId) {
		this.courseScheduleId = courseScheduleId;
	}

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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
}
