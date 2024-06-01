package com.vsu.cs.maslova_e_i.service;

import com.vsu.cs.maslova_e_i.entity.Department;
import com.vsu.cs.maslova_e_i.entity.Patient;
import com.vsu.cs.maslova_e_i.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    
    public void create(Department department) {
        departmentRepository.create(department);
    }

    
    public void delete(int id) {
        departmentRepository.delete(id);
    }

    
    public void update(Department department) {
        departmentRepository.update(department);
    }

    
    public Department findById(int id) {
        return departmentRepository.findById(id);
    }

    
    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    
    public List<Patient> getPatientsByDepartmentId(int departmentId) {
        return departmentRepository.getPatientsByDepartmentId(departmentId);
    }
}
