package com.vsu.cs.maslova_e_i.service;

import com.vsu.cs.maslova_e_i.entity.Department;
import com.vsu.cs.maslova_e_i.entity.Patient;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentService departmentService;

    @Override
    public void create(Department department) {
        departmentService.create(department);
    }

    @Override
    public void delete(int id) {
        departmentService.delete(id);
    }

    @Override
    public void update(Department department) {
        departmentService.update(department);
    }

    @Override
    public Department findById(int id) {
        return departmentService.findById(id);
    }

    @Override
    public List<Patient> getAllDepartmentPatients() {
        return departmentService.getAllDepartmentPatients();
    }
}
