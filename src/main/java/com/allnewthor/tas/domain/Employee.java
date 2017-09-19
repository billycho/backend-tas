package com.allnewthor.tas.domain;

import java.util.List;
<<<<<<< HEAD
import java.util.Set;
=======
>>>>>>> feature-connectdb-role-employee_w_1-many

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Employee")
public class Employee {
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO )
	@Column(name = "employeeid")
	private Integer employeeId;
	
	@Column(name = "fullname")
	private String fullname;
	
	@ManyToOne
	@JoinColumn(name = "gradeid")
	private Grade grade;
	
	@Column (name = "stream")
	private String stream;
	
	@Column (name = "active")
	private boolean active;
	
	@ManyToOne
	@JoinColumn (name = "locationid")
	private Location location;
	
	@Column (name = "accountname")
	private String accountName;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "accountpassword")
	private String accountPassword;
	
	@Column (name = "salt")
	private String salt;	
	
	@ManyToMany
	@JoinTable(
	 name="tasuser",
	 joinColumns = @JoinColumn(name = "employeeid", referencedColumnName = "employeeid"),
	 inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "roleid")
	)	
	
	private List<Role> roles;
	
	public Employee() {
		super();
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
