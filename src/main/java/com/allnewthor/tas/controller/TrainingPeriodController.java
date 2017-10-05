package com.allnewthor.tas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.allnewthor.tas.domain.CourseRepository;
import com.allnewthor.tas.domain.CourseSchedule;
import com.allnewthor.tas.domain.CourseScheduleRepository;
import com.allnewthor.tas.domain.EligibleParticipant;
import com.allnewthor.tas.domain.EligibleRepository;
import com.allnewthor.tas.domain.Employee;
import com.allnewthor.tas.domain.EmployeeRepository;
import com.allnewthor.tas.domain.TrainingPeriod;
import com.allnewthor.tas.domain.TrainingPeriodRepository;

@RestController
@RequestMapping("/periods")
public class TrainingPeriodController {
	@Autowired
	private TrainingPeriodRepository periodRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EligibleRepository eligibleRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseScheduleRepository scheduleRepository;
	
	@GetMapping(value="")
	public List<TrainingPeriod> getAll(Model model){
		return periodRepository.findAll();
	}
	

	@GetMapping(value="/{id}")
	public TrainingPeriod getById(@PathVariable ("id")Integer id){
		return periodRepository.findOne(id);
	}

	
	@PostMapping (value = "/add")
	public TrainingPeriod postPeriod(
			@RequestBody String body
			) throws JSONException  { 
		
		JSONObject obj = new JSONObject(body);
				
		String periodName = obj.getString("periodName");
		
		String startDate = obj.getString("startDate");
		String endDate = obj.getString("endDate");
		String createdDate = obj.getString("createdDate");
		boolean openEnrollment = obj.getBoolean("openenrollment");
		boolean periodical = obj.getBoolean("periodical");
		
		Integer creatorId = obj.getInt("creatorId");
		
		TrainingPeriod period;
		period = new TrainingPeriod();
		period.setPeriodName(periodName);
		period.setStartDate(startDate);
		period.setEndDate(endDate);
		period.setCreatedData(createdDate);
		period.setUpdatedDate(createdDate);
		period.setOpenenrollment(openEnrollment);
		period.setPeriodical(periodical);
		period.setActive(true);
		
		Employee employee = new Employee();
		employee = employeeRepository.findOne(creatorId);
		period.setEmployee(employee);
		period.setUpdaterID(employee);
		
	    periodRepository.save(period);
		
		
		return periodRepository.findOne(period.getTrainingPeriodId());

	}
	
	@PostMapping (value = "/edit")
	public TrainingPeriod editPeriod(
			@RequestBody String body
			) throws JSONException  { 
		
		JSONObject obj = new JSONObject(body);
				

		Integer trainingId = obj.getInt("trainingPeriodId");
		

		TrainingPeriod period  = periodRepository.findOne(trainingId);
		
		String periodName = obj.getString("periodName");
		
		String startDate = obj.getString("startDate");
		String endDate = obj.getString("endDate");
		String createdDate = obj.getString("createdDate");
		String updatedDate = obj.getString("updateDate");
		boolean openEnrollment = obj.getBoolean("openenrollment");
		boolean periodical = obj.getBoolean("periodical");
		
		Integer creatorId = obj.getInt("creatorId");
		
		
		period.setPeriodName(periodName);
		period.setStartDate(startDate);
		period.setEndDate(endDate);
		period.setUpdatedDate(updatedDate);
		period.setOpenenrollment(openEnrollment);
		period.setPeriodical(periodical);
		
		Employee employee = new Employee();
		employee = employeeRepository.findOne(creatorId);
		period.setEmployee(employee);
		period.setUpdaterID(employee);
		
	    periodRepository.save(period);
		
		
		return periodRepository.findOne(period.getTrainingPeriodId());

	}
	

	
	@GetMapping(value="/{id}/employee")
	public List<Employee> getAll1(Model model,@PathVariable("id")Integer trainingid)
	{
		TrainingPeriod period = periodRepository.findOne(trainingid);
		List<EligibleParticipant> eligibleDatas = eligibleRepository.findBytrainingPeriod(period);
		List<Employee> data = new ArrayList<Employee>();
		
		for(int i = 0; i<eligibleDatas.size(); i++)
		{
			data.add(eligibleDatas.get(i).getEmployee());
		}
		
		return data;
	}
	
	@PostMapping (value = "/{id}/addemployee")
	public EligibleParticipant addEmployee(@PathVariable("id")Integer trainingId,@RequestBody String body) throws JSONException 
	{
		JSONObject obj = new JSONObject(body);
	
		Integer employeeId = obj.getInt("employeeId");
		TrainingPeriod trainingPeriod = periodRepository.findOne(trainingId);
		Employee employee = employeeRepository.findOne(employeeId);
		
		EligibleParticipant newEligible = new EligibleParticipant();
		newEligible.setEmployee(employee);
		newEligible.setTrainingPeriod(trainingPeriod);
		
		eligibleRepository.save(newEligible);
		
		return eligibleRepository.findOne(newEligible.getEligibleParticipantID());
	}
	
	@PostMapping (value = "/{id}/deleteemployee")
	public Integer deleteEmployee(@PathVariable("id")Integer trainingId,@RequestBody String body) throws JSONException 
	{
		JSONObject obj = new JSONObject(body);
	
		Integer employeeId = obj.getInt("employeeId");
		TrainingPeriod trainingPeriod = periodRepository.findOne(trainingId);
		Employee employee = employeeRepository.findOne(employeeId);
		
		List<EligibleParticipant> oldEligible = eligibleRepository.findByEmployeeAndTrainingPeriod(employee,trainingPeriod);
		eligibleRepository.delete(oldEligible);
//		EligibleParticipant newEligible = new EligibleParticipant();
//		newEligible.setEmployee(employee);
//		newEligible.setTrainingPeriod(trainingPeriod);
		
		//eligibleRepository.save(newEligible);
		
		return 200;
	}
	
	@GetMapping(value = "/{id}/delete")
	public Integer deletePeriod(@PathVariable("id") Integer trainingId)
	{
		TrainingPeriod trainingPeriod = periodRepository.findOne(trainingId);
		
		trainingPeriod.setActive(false);
		periodRepository.save(trainingPeriod);
		
		
		return 200;
	}
	
	@GetMapping(value = "/active")
	public List<CourseSchedule> getActive() throws ParseException
	{
		
		
		
		List<TrainingPeriod> periods = periodRepository.findAll();
		List<TrainingPeriod> activePeriods = new ArrayList<TrainingPeriod>();
		List<Course> activeCourse = new ArrayList<Course>();
		List<CourseSchedule> activeSchedule = new ArrayList<CourseSchedule>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for(int i = 0;i<periods.size();i++)
		{
			
			if(isDateInBetweenIncludingEndPoints(new Date(sdf.parse(periods.get(i).getStartDate()).getTime()), new Date(sdf.parse(periods.get(i).getEndDate()).getTime()), new Date()))
			{
				activePeriods.add(periods.get(i));
				List<Course> newcourses = courseRepository.findBytrainingPeriod(periods.get(i));
				for(int j = 0;j<newcourses.size();j++)
				{
					List<CourseSchedule> listSchedule = scheduleRepository.findBycourse(newcourses.get(j));
					activeSchedule.add(listSchedule.get(0));
					activeCourse.add(newcourses.get(j));
				}
			}
		}
		
		return activeSchedule;
	}
	
	@GetMapping(value = "/activebcc")
	public List<CourseSchedule> getActiveBCC() throws ParseException
	{
		
		
		System.out.println("a");
		List<TrainingPeriod> periods = periodRepository.findAll();
		List<TrainingPeriod> activePeriods = new ArrayList<TrainingPeriod>();
		List<Course> activeCourse = new ArrayList<Course>();
		List<CourseSchedule> activeSchedule = new ArrayList<CourseSchedule>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for(int i = 0;i<periods.size();i++)
		{
			
			if(isDateInBetweenIncludingEndPoints(new Date(sdf.parse(periods.get(i).getStartDate()).getTime()), new Date(sdf.parse(periods.get(i).getEndDate()).getTime()), new Date()))
			{
				activePeriods.add(periods.get(i));
				List<Course> newcourses = courseRepository.findBytrainingPeriod(periods.get(i));
				System.out.println(newcourses.size());
				for(int j = 0;j<newcourses.size();j++)
				{
					List<CourseSchedule> listSchedule = scheduleRepository.findBycourse(newcourses.get(j));
					if(newcourses.get(j).getCoursename().getCoursetype().equals("BCC"))
					{
						activeSchedule.add(listSchedule.get(0));
					}
					
				}
			}
		}
		
		return activeSchedule;
	}
	
	public static boolean isDateInBetweenIncludingEndPoints(final Date min, final Date max, final Date date){
	    return !(date.before(min) || date.after(max));
	}
	
}
