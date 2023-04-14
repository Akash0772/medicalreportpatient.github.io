package com.akash.medicalreportpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.medicalreportpatient.entity.Patient;



@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
}
