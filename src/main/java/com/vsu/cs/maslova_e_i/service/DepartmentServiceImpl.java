package com.vsu.cs.maslova_e_i.service;

import com.vsu.cs.maslova_e_i.entity.Department;
import com.vsu.cs.maslova_e_i.entity.Patient;
import com.vsu.cs.maslova_e_i.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public void create(Department department) {
        departmentRepository.create(department);
    }

    @Override
    public void delete(int id) {
        departmentRepository.delete(id);
    }

    @Override
    public void update(Department department) {
        departmentRepository.update(department);
    }

    @Override
    public Department findById(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    @Override
    public List<Patient> getPatientsByDepartmentId(int departmentId) {
        return departmentRepository.getPatientsByDepartmentId(departmentId);
    }
}
