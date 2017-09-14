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
@Table(name = "Room")
public class Room {
	
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO )
	@Column(name = "roomid")
	private Integer roomId;
	
	@Column(name = "roomname")
	private String roomName;
	
	@ManyToOne
	@JoinColumn(name = "locationid")
	private Location location;
//	private Integer location;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
