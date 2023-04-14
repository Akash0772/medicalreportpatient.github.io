package com.akash.medicalreportpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akash.medicalreportpatient.entity.Patient;
import com.akash.medicalreportpatient.repository.PatientRepository;
import com.akash.medicalreportpatient.service.PatientService;



@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public String getAllPatients(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patient-list";
    }

    @GetMapping("/add-patient")
    public String addPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @PostMapping("/add-patient")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/";
    }

    @GetMapping("/update-patient/{id}")
    public String updatePatientForm(@PathVariable("id") Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) {
            return "redirect:/";
        }
        model.addAttribute("patient", patient);
        return "update-patient";
    }

    @PostMapping("/update-patient/{id}")
    public String updatePatient(@PathVariable("id") Long id, @ModelAttribute("patient") Patient patient) {
        patientService.updatePatient(id, patient);
        return "redirect:/";
    }

    @GetMapping("/delete-patient/{id}")
    public String deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
        return "redirect:/";
    }
    
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/patients")
    public String addPatientString(@ModelAttribute("patient") Patient patient) {
      patientRepository.save(patient);
      return "redirect:/patients";
    }


}
