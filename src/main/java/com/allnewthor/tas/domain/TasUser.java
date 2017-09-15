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
@Table(name = "tasuser")
public class TasUser {
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO )
	@Column (name = "tasuserid")
	private Integer tasUserId;
	
	@ManyToOne
	@JoinColumn (name = "employeeid")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn (name = "roleid")
	private Role role;

	public Integer getTasUserId() {
		return tasUserId;
	}

	public void setTasUserId(Integer tasUserId) {
		this.tasUserId = tasUserId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
