package com.allnewthor.tas.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allnewthor.tas.domain.Employee;
import com.allnewthor.tas.domain.EmployeeRepository;
import com.allnewthor.tas.domain.Role;

@Controller
public class LoginController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@RequestMapping(path="/create", method=RequestMethod.POST)
	@ResponseBody
	public LoginResponse authenticate(@RequestBody final LoginRequest loginRequest) throws NoSuchAlgorithmException{
		
		LoginResponse loginResponse = new LoginResponse();
		
		Employee employee = new Employee();
		employee = employeeRepository.findByAccountName(loginRequest.getUsername());
		
	
		
		if(employee!= null && encrpyt(loginRequest.getPassword() + employee.getSalt()).equals(employee.getAccountPassword()))
		{
			loginResponse.setName(employee.getAccountName());
			loginResponse.setEmployeeId(1);
			loginResponse.setStatus(1);
			
			List<Role> roles = employee.getRoles();
			int biggest = 0;
			
			//System.out.println(roles.size());
			
			for(int i = roles.size()-1;i>=0;i--)
			{
			   loginResponse.setRole(roles.get(i).getRoleId());
			}
		
		}
		else
		{
			loginResponse.setName("0");
			loginResponse.setEmployeeId(0);
			loginResponse.setStatus(0);
		
		}
		
		
		return  loginResponse;
	}
	
	@RequestMapping(path="/boot", method=RequestMethod.GET)
	@ResponseBody
	public String boot() throws NoSuchAlgorithmException{
		
		return encrpyt("Sanur_2017!ewusa");
	}
	
	
	public String encrpyt(String password) throws NoSuchAlgorithmException
	{
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());
	    byte[] digest = md.digest();
	    String myHash = DatatypeConverter
	      .printHexBinary(digest).toUpperCase();
	    
	    return myHash;
	}
	
	
}
	





