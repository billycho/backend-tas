package com.allnewthor.tas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table (name = "trainingperiod")
public class TrainingPeriod {
  @Id
  @GeneratedValue( strategy=GenerationType.AUTO)
  @Column(name = "trainingperiodid")
  private Integer trainingPeriodId;
  
  @Column(name = "periodname")
  private String periodName;
  
  @Column(name = "startdate")
  private String startDate;
  
  @Column(name = "enddate")
  private String endDate;
  
  @ManyToOne
  @JoinColumn(name = "creatorid")
  private Employee employee;
  
  @Column(name = "createddate")
  private String createdDate;
  
  @ManyToOne
  @JoinColumn(name = "updaterid")
  private Employee updaterID;
  
  @Column(name = "updatedate")
  private String updatedDate;
  
  @Column(name = "openenrollment")
  private boolean openEnrollment;

  @Column(name = "periodical")
  private boolean periodical;

@Column(name = "openenrollment")
 private boolean openenrollment;
  
  public TrainingPeriod() {
	  super();
  }
  
  public boolean isOpenenrollment() {
	return openenrollment;
}

public void setOpenenrollment(boolean openenrollment) {
	this.openenrollment = openenrollment;
}

public Integer getTrainingPeriodId() {
	return trainingPeriodId;
}

public void setTrainingPeriodId(Integer trainingPeriodId) {
	this.trainingPeriodId = trainingPeriodId;
}

public String getPeriodName() {
	return periodName;
}

public void setPeriodName(String periodName) {
	this.periodName = periodName;
}

public String getStartDate() {
	return startDate;
}

public void setStartDate(String startDate) {
	this.startDate = startDate;
}

public String getEndDate() {
	return endDate;
}

public void setEndDate(String endDate) {
	this.endDate = endDate;
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

public String getCreatedDate() {
	return createdDate;
}

public void setCreatedData(String createdDate) {
	this.createdDate = createdDate;
}

public Employee getUpdaterID() {
	return updaterID;
}

public void setUpdaterID(Employee updaterID) {
	this.updaterID = updaterID;
}

public boolean isOpenEnrollment() {
	return openEnrollment;
}

public void setOpenEnrollment(boolean openEnrollment) {
	this.openEnrollment = openEnrollment;
}

public boolean isPeriodical() {
	return periodical;
}

public void setPeriodical(boolean periodical) {
	this.periodical = periodical;
}

public String getUpdatedDate() {
	return updatedDate;
}

public void setUpdatedDate(String updatedDate) {
	this.updatedDate = updatedDate;
}
  
}
