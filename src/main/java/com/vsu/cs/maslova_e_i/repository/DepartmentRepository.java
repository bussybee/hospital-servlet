package com.vsu.cs.maslova_e_i.repository;

import com.vsu.cs.maslova_e_i.entity.Department;
import com.vsu.cs.maslova_e_i.entity.Patient;

import java.util.List;

public interface DepartmentRepository {
    int create(Department department);
    int delete(int id);
    int update(Department department);
    Department findById(int id);
    List<Department> getAllDepartments();
    List<Patient> getPatientsByDepartmentId(int departmentId);
}
