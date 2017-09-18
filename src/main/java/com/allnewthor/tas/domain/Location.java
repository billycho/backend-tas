package com.allnewthor.tas.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Location")
public class Location implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="locationid")
	 private Integer locationId;
	
	@Column(name="locationname")
	 private String locationName;

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

<<<<<<< HEAD
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
=======
	public String getlocationName() {
		return locationName;
	}

	public void setlocationName(String locationName) {
>>>>>>> feature-coursename
		this.locationName = locationName;
	}
	
	
}
