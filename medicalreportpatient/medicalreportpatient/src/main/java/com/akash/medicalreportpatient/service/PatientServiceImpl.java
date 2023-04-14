package com.akash.medicalreportpatient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.medicalreportpatient.entity.Patient;
import com.akash.medicalreportpatient.repository.PatientRepository;



@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void updatePatient(Long id, Patient patient) {
        Patient existingPatient = patientRepository.findById(id).orElse(null);
        if (existingPatient != null) {
            existingPatient.setName(patient.getName());
            existingPatient.setDateOfBirth(patient.getDateOfBirth());
            existingPatient.setGender(patient.getGender());
            existingPatient.setAddress(patient.getAddress());
            patientRepository.save(existingPatient);
        }
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}
