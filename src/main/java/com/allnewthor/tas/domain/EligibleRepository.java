package com.allnewthor.tas.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EligibleRepository extends JpaRepository<EligibleParticipant, Integer> {
	List<EligibleParticipant> findBytrainingPeriod (TrainingPeriod id);
	List<EligibleParticipant> findByEmployeeAndTrainingPeriod(Employee empid,TrainingPeriod trainingid);
}
