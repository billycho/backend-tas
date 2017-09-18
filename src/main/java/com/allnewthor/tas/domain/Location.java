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

	public String getLocationName() {
		return locationName;
	}


	public void setlocationName(String locationName) {
		this.locationName = locationName;
	}
	
	
}
