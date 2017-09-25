package com.allnewthor.tas.controller;

import com.allnewthor.tas.domain.Role;

public class LoginResponse {
	private Integer employeeId;
	private Integer status;
	private Integer role;
	private String name;
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getRole()
	{
		return role;
	}
	
	public void setRole(Integer role)
	{
		this.role = role;
	}
}
