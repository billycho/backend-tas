package com.allnewthor.tas.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue
	@Column(name="courseid")
	private Integer courseId;
	
	@ManyToOne
	@JoinColumn(name="coursenameid")
	private CourseName coursename;
	
	@ManyToOne
	@JoinColumn(name="trainingperiodid")
	private TrainingPeriod trainingPeriod;
	
	@Column(name="capacity")
	private Integer capacity;
	
	@ManyToOne
	@JoinColumn(name="maintrainerid")
	private Employee mainTrainer;
	
	@ManyToOne
	@JoinColumn(name="backuptrainerid", nullable=true)
	private Employee backUpTrainer;
	
	@OneToMany(mappedBy="course",fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<CourseParticipant> courseParticipant;
	
	@OneToMany( targetEntity=CourseSchedule.class, fetch = FetchType.LAZY )
	@JoinColumn(name = "coursescheduleid")
	private List<CourseSchedule> courseSchedule;
	
	public Course() {
		super();
	}

	public void addCourseParticipant(CourseParticipant courseParticipant) {
		if(this.courseParticipant.size()<=0) {
			this.courseParticipant = new ArrayList<CourseParticipant>();
		}
		this.courseParticipant.add(courseParticipant);
	}
	
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public CourseName getCoursename() {
		return coursename;
	}

	public void setCoursename(CourseName coursename) {
		this.coursename = coursename;
	}

	public TrainingPeriod getTrainingPeriod() {
		return trainingPeriod;
	}

	public void setTrainingPeriod(TrainingPeriod trainingPeriod) {
		this.trainingPeriod = trainingPeriod;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Employee getMainTrainer() {
		return mainTrainer;
	}

	public void setMainTrainer(Employee mainTrainer) {
		this.mainTrainer = mainTrainer;
	}

	public Employee getBackUpTrainer() {
		return backUpTrainer;
	}

	public void setBackUpTrainer(Employee backUpTrainer) {
		this.backUpTrainer = backUpTrainer;
	}
	
	@JsonIgnore
	public List<CourseParticipant> getCourseParticipant() {
		return courseParticipant;
	}

	public void setCourseParticipant(List<CourseParticipant> courseParticipant) {
		this.courseParticipant = courseParticipant;
	}
	
	@JsonIgnore
	public List<CourseSchedule> getCourseSchedule() {
		return courseSchedule;
	}

	public void setCourseSchedule(List<CourseSchedule> courseSchedule) {
		this.courseSchedule = courseSchedule;
	}
}
