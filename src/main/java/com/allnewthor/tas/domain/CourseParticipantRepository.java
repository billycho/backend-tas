package com.allnewthor.tas.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseParticipantRepository extends JpaRepository<CourseParticipant, Integer> {
	List<CourseParticipant> findBycourse (Course id);
	List<CourseParticipant> findByemployee(Employee id);
	List<CourseParticipant> findByEmployeeAndCourse(Employee empid,Course courseid);
}
