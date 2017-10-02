package com.allnewthor.tas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eligibleparticipant")
public class EligibleParticipant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="eligibleparticipantid")
	 private Integer eligibleParticipantID;
	
	
	@ManyToOne
	@JoinColumn(name="employeeid")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="trainingperiodid")
	private TrainingPeriod trainingPeriod;
	
	@Column(name="status")
	private boolean status;
	
	
	public EligibleParticipant() {
		super();
	}


	public Integer getEligibleParticipantID() {
		return eligibleParticipantID;
	}


	public void setEligibleParticipantID(Integer eligibleParticipantID) {
		this.eligibleParticipantID = eligibleParticipantID;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public TrainingPeriod getTrainingPeriod() {
		return trainingPeriod;
	}


	public void setTrainingPeriod(TrainingPeriod trainingPeriod) {
		this.trainingPeriod = trainingPeriod;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
