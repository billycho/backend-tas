package com.allnewthor.tas.domain;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class ExportAchievement extends AbstractXlsView{
	
	 @Autowired
	 private CourseParticipantRepository courseParticipantRepository;
	 
	 @Override
	 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
	 HttpServletResponse response) throws Exception {
		 
	 
	  
	 response.setHeader("Content-Disposition", "attachment;filename=\"achievement.xls\"");
	 List<CourseParticipant> courseParticipantList = (List<CourseParticipant>) model.get("courseParticipantList");
	 Sheet sheet = workbook.createSheet("Achievement Data");
	 Row header = sheet.createRow(0);
	 header.createCell(0).setCellValue("Employee Id");
	 header.createCell(1).setCellValue("FullName");
	 header.createCell(2).setCellValue("Job Family");
	 header.createCell(3).setCellValue("Grade");
	 header.createCell(4).setCellValue("Location");
	 header.createCell(5).setCellValue("Course");
	 header.createCell(6).setCellValue("Course Type");
	 header.createCell(7).setCellValue("Period");
	 header.createCell(8).setCellValue("Start Date");
	 header.createCell(9).setCellValue("End Date");
	 header.createCell(10).setCellValue("Main Trainer");
	 header.createCell(11).setCellValue("Status");
	 
	  
	 int rowNum = 1;
	 for(int i=0; i < courseParticipantList.size(); i++){
		 Row row = sheet.createRow(rowNum++);
		 row.createCell(0).setCellValue(courseParticipantList.get(i).getEmployee().getEmployeeId());
		 row.createCell(1).setCellValue(courseParticipantList.get(i).getEmployee().getFullname());
		 row.createCell(2).setCellValue(courseParticipantList.get(i).getEmployee().getGrade().getJobfamily());
		 row.createCell(3).setCellValue(courseParticipantList.get(i).getEmployee().getGrade().getGrade());
		 row.createCell(4).setCellValue(courseParticipantList.get(i).getEmployee().getLocation().getLocationName());
		 row.createCell(5).setCellValue(courseParticipantList.get(i).getCourse().getCoursename().getCoursename());
		 row.createCell(6).setCellValue(courseParticipantList.get(i).getCourse().getCoursename().getCoursetype());
		 row.createCell(7).setCellValue(courseParticipantList.get(i).getCourse().getTrainingPeriod().getPeriodName());
		 row.createCell(8).setCellValue(courseParticipantList.get(i).getCourse().getTrainingPeriod().getStartDate());
		 row.createCell(9).setCellValue(courseParticipantList.get(i).getCourse().getTrainingPeriod().getEndDate());
		 row.createCell(10).setCellValue(courseParticipantList.get(i).getCourse().getMainTrainer().getFullname());
		 
		 if(courseParticipantList.get(i).getPass()==null) {
			 row.createCell(11).setCellValue("In Progress");
		 }else if(courseParticipantList.get(i).getPass()==true) {
			 row.createCell(11).setCellValue("Passed");
		 }else if(courseParticipantList.get(i).getPass()==false) {
			 row.createCell(11).setCellValue("Failed");
		 }
	 	}
	 }
	}