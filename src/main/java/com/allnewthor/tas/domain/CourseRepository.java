package com.allnewthor.tas.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer>  {
	List<Course> findBytrainingPeriod (TrainingPeriod id);
}
