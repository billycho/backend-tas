package com.allnewthor.tas;

import java.util.List;

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
	public LoginResponse authenticate(@RequestBody final LoginRequest loginRequest){
		
		LoginResponse loginResponse = new LoginResponse();
		
		Employee employee = new Employee();
		employee = employeeRepository.findByAccountName(loginRequest.getUsername());
		
		List<Role> roles = employee.getRoles();
		int biggest = 0;
		
		System.out.println(roles.size());
		
		for(int i = roles.size()-1;i>=0;i--)
		{
		   loginResponse.setRole(roles.get(i).getRoleId());
		}
		
		
		if(loginRequest.getPassword().equals(employee.getAccountPassword()))
		{
			loginResponse.setName(employee.getAccountName());
			loginResponse.setEmployeeId(1);
			loginResponse.setStatus(1);
		
		}
		else
		{
			loginResponse.setName("0");
			loginResponse.setEmployeeId(0);
			loginResponse.setStatus(0);
		
		}
		
		
		return  loginResponse;
	}
	
	
}
	





