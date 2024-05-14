package com.vsu.cs.maslova_e_i.service;

import com.vsu.cs.maslova_e_i.entity.Department;
import com.vsu.cs.maslova_e_i.entity.Patient;

import java.util.List;

public interface DepartmentService {
    void create(Department department);
    void delete(int id);
    void update(Department department);
    Department findById(int id);
    List<Patient> getAllDepartmentPatients();
}
