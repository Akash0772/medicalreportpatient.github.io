package com.akash.medicalreportpatient.service;

import java.util.List;

import com.akash.medicalreportpatient.entity.Patient;





public interface PatientService {

    List<Patient> getAllPatients();

    Patient getPatientById(Long id);

    void savePatient(Patient patient);

    void updatePatient(Long id, Patient patient);

    void deletePatient(Long id);

}
