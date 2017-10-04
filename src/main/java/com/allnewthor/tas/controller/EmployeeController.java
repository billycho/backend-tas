package com.allnewthor.tas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allnewthor.tas.domain.Course;
import com.allnewthor.tas.domain.CourseParticipant;
import com.allnewthor.tas.domain.CourseParticipantRepository;
import com.allnewthor.tas.domain.Employee;
import com.allnewthor.tas.domain.EmployeeRepository;
import com.allnewthor.tas.domain.Role;
import com.allnewthor.tas.domain.RoleRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CourseParticipantRepository courseParticipantRepository;
	
	@GetMapping(value="")
	public List<Employee> getAll(Model model){
		return employeeRepository.findAll();
	}
	
	@GetMapping(value="/users")
	public List<Employee> getAllUsers(Model model){
		return isUser(employeeRepository.findAll(),employee->employee.hasRoles());
	}
	
	private List<Employee> isUser(List<Employee> employees, Predicate<Employee> p) {
		List<Employee> result = new ArrayList<Employee>();
		for(Employee employee: employees) {
	        if(p.test(employee)) {
	          result.add(employee);
	        }
	     }
		return result;
	}
	
	
	@GetMapping (value ="/{id}")
	public Employee getById(@PathVariable("id") Integer id){
		return employeeRepository.findOne(id);
	}
	
	@GetMapping (value ="/{id}/courses")
	public List<CourseParticipant> getCourses(@PathVariable("id") Integer id){
		return employeeRepository.findOne(id).getCourseParticipant();
	}
	@GetMapping (value ="/{id}/courses/bcc")
	public List<CourseParticipant> getBCCCourse(@PathVariable("id") Integer id){
		List<CourseParticipant> result = new ArrayList<CourseParticipant>();
		List<CourseParticipant> temp = new ArrayList<CourseParticipant>();	
		temp = employeeRepository.findOne(id).getCourseParticipant();
		for (int i = 0; i <temp.size(); i++) {
			if (temp.get(i).getCourse().getCoursename().getCoursetype().equals("BCC")) {
				result.add(temp.get(i));
			}
		}
		return result;
	}
	
	@GetMapping (value ="/{id}/courses/{coursenameid}")
	public List<CourseParticipant> getBCCCourse(@PathVariable("id") Integer id,
			@PathVariable ("coursenameid")Integer coursenameid){
		List<CourseParticipant> result = new ArrayList<CourseParticipant>();
		List<CourseParticipant> temp = new ArrayList<CourseParticipant>();	
		temp = employeeRepository.findOne(id).getCourseParticipant();
		for (int i = 0; i <temp.size(); i++) {
			if (temp.get(i).getCourse().getCoursename().getCoursenameid()==coursenameid) {
				result.add(temp.get(i));
			}
		}
		return result;
	}
	
	
	
	@PostMapping (value = "/addrole")
	public Employee postRole(
			@RequestBody Map<String,String> tasuser
			) { 
		Integer employee_id = Integer.parseInt(tasuser.get("employeeId"));
		Integer role_id = Integer.parseInt(tasuser.get("roleId"));
		
		Employee employee = new Employee();
		employee = employeeRepository.findOne(employee_id);
	
		Role role = new Role();
		role = roleRepository.findOne(role_id);
		List<Role> roles = employee.getRoles();
		roles.add(role);
		
		employee.setRoles(roles);
		
		employeeRepository.save(employee);
		
		return employeeRepository.findOne(employee.getEmployeeId());
	}
	
	@PostMapping (value = "/update")
	public Employee update(
			@RequestBody String body
			) throws JSONException { 
		
		JSONObject obj = new JSONObject(body);
		
		Integer id = obj.getInt("employeeId");
		boolean active = obj.getBoolean("active");
		
		JSONArray arr = obj.getJSONArray("roles");
		
		List<Role> roles = new ArrayList<Role>();
		
		for(int i= 0; i < arr.length();i++)
		{
			JSONObject arrobj = arr.getJSONObject(i);
			
			Role role = new Role();
			role.setRoleId(arrobj.getInt("roleId"));
			role.setRoleName(arrobj.getString("roleName"));
			
			roles.add(role);
		}
		
		
		Employee employee = new Employee();
		employee = employeeRepository.findOne(id);
		employee.setRoles(roles);
		employee.setActive(active);
		employeeRepository.save(employee);
		
		return employeeRepository.findOne(id);
	}
	
	@GetMapping (value ="/{id}/enrolled")
	public List<Course> getEnrolledCourse(@PathVariable("id") Integer id){
		Employee employee = employeeRepository.findOne(id);
		List<Course> courseList = new ArrayList<Course>();
		System.out.println(courseParticipantRepository.count());
		for(int i = 0;i<courseParticipantRepository.findByemployee(employee).size();i++)
		{
			courseList.add(courseParticipantRepository.findByemployee(employee).get(i).getCourse());
		}
		return courseList;
	}
	
	@GetMapping (value ="/{id}/enrolledstatus")
	public List<Boolean> getEnrolledStatus(@PathVariable("id") Integer id){
		Employee employee = employeeRepository.findOne(id);
		List<Boolean> status = new ArrayList<Boolean>();
		System.out.println(courseParticipantRepository.count());
		for(int i = 0;i<courseParticipantRepository.findByemployee(employee).size();i++)
		{
			status.add(courseParticipantRepository.findByemployee(employee).get(i).getPass());
	
		}
		return status;
	}
	
}
