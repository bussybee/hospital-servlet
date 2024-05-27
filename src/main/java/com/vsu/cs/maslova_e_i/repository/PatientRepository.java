package com.vsu.cs.maslova_e_i.repository;

import com.vsu.cs.maslova_e_i.entity.Patient;

import java.util.List;

public interface PatientRepository {
    int create(Patient patient);
    int delete(int id);
    int update(Patient patient);
    Patient findById(int id);
    List<Patient> getAllPatients();
}
