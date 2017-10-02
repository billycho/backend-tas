package com.allnewthor.tas.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseNameRepository extends JpaRepository<CourseName,Integer> {
	List<CourseName> findByCoursetype(String coursetype);
}
