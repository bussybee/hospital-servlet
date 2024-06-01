package com.vsu.cs.maslova_e_i.repository;

import com.vsu.cs.maslova_e_i.config.DatabaseConfig;
import com.vsu.cs.maslova_e_i.entity.Department;
import com.vsu.cs.maslova_e_i.entity.Patient;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DepartmentRepository extends DatabaseConfig {
    private static final String INSERT_QUERY = "INSERT INTO departments (name) VALUES (?)";
    private static final String UPDATE_QUERY = "UPDATE departments SET name = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM departments WHERE id = ?";
    private static final String GET_DEPART_BY_ID = "SELECT * FROM departments WHERE id = ?";
    private static final String GET_ALL_DEPARTMENTS = "SELECT * FROM departments";
    private static final String GET_PATIENTS_BY_DEPARTMENT_ID = "SELECT * FROM patients WHERE department_id = ?";

    public int create(Department department) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, department.getName());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating department", e);
        }
    }

    public int delete(int id) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting department", e);
        }
    }

    public int update(Department department) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, department.getName());
            statement.setInt(2, department.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating department", e);
        }
    }

    public Department findById(int id) {
        Department department = null;
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(GET_DEPART_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                department = Department.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding department by id", e);
        }
        return department;
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_DEPARTMENTS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Department department = Department.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
                departments.add(department);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting all departments", e);
        }
        return departments;
    }

    public List<Patient> getPatientsByDepartmentId(int departmentId) {
        List<Patient> patients = new ArrayList<>();
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(GET_PATIENTS_BY_DEPARTMENT_ID);
            statement.setInt(1, departmentId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Patient patient = Patient.builder()
                        .id(resultSet.getInt("id"))
                        .fullName(resultSet.getString("full_name"))
                        .age(resultSet.getInt("age"))
                        .gender(resultSet.getString("gender"))
                        .departmentName(resultSet.getString("department_id"))
                        .build();
                patients.add(patient);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting patients by department id", e);
        }
        return patients;
    }
}
