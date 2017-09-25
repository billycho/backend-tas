package com.allnewthor.tas.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.allnewthor.tas.domain.EmployeeRepository;

public class LoginRequest {
	
	
	
public LoginRequest()
{
	
}

private String username;
private String password;

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
