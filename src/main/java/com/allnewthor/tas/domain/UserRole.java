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
@Table(name = "UserRole")
public class UserRole {
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO )
	@Column (name = "userroleid")
	private Integer userRoleId;
	
	@ManyToOne
	@JoinColumn (name = "employeeid")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn (name = "roleid")
	private Role role;

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
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
