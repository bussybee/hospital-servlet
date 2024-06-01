package com.vsu.cs.maslova_e_i.repository;

import com.vsu.cs.maslova_e_i.config.DatabaseConfig;
import com.vsu.cs.maslova_e_i.entity.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository extends DatabaseConfig {
    private static final String INSERT_QUERY = "INSERT INTO patients (full_name, age, gender, department_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE patients SET full_name = ?, age = ?, gender = ?, department_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM patients WHERE id = ?";
    private static final String GET_PAT_BY_ID = "SELECT * FROM patients WHERE id = ?";
    private static final String GET_ALL_PATIENTS = "SELECT * FROM patients";

    
    public int create(Patient patient) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, patient.getFullName());
            statement.setInt(2, patient.getAge());
            statement.setString(3, patient.getGender());
            statement.setString(4, patient.getDepartmentName());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating patient", e);
        }
    }

    
    public int delete(int id) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting patient", e);
        }
    }

    
    public int update(Patient patient) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, patient.getFullName());
            statement.setInt(2, patient.getAge());
            statement.setString(3, patient.getGender());
            statement.setString(4, patient.getDepartmentName());
            statement.setInt(5, patient.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating patient", e);
        }
    }

    
    public Patient findById(int id) {
        Patient patient = null;
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(GET_PAT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                patient = Patient.builder()
                        .id(resultSet.getInt("id"))
                        .fullName(resultSet.getString("full_name"))
                        .age(resultSet.getInt("age"))
                        .gender(resultSet.getString("gender"))
                        .departmentName(resultSet.getString("department_name"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding patient by id", e);
        }
        return patient;
    }

    
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_PATIENTS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Patient patient = Patient.builder()
                        .id(resultSet.getInt("id"))
                        .fullName(resultSet.getString("full_name"))
                        .age(resultSet.getInt("age"))
                        .gender(resultSet.getString("gender"))
                        .departmentName(resultSet.getString("department_name"))
                        .build();
                patients.add(patient);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting all patients", e);
        }
        return patients;
    }
}
