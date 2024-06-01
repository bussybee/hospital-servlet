package com.vsu.cs.maslova_e_i.service;

import com.vsu.cs.maslova_e_i.entity.Patient;
import com.vsu.cs.maslova_e_i.repository.PatientRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PatientService {
    private PatientRepository patientRepository;

    
    public int create(Patient patient) {
        return patientRepository.create(patient);
    }

    
    public int delete(int id) {
        return patientRepository.delete(id);
    }

    
    public int update(Patient patient) {
        return patientRepository.update(patient);
    }

    
    public Patient findById(int id) {
        return patientRepository.findById(id);
    }

    
    public List<Patient> getAllPatientsWithDepartments() {
        return patientRepository.getAllPatients();
    }
}
