package com.vsu.cs.maslova_e_i.repository;

import com.vsu.cs.maslova_e_i.config.DatabaseConfig;
import com.vsu.cs.maslova_e_i.entity.Department;
import com.vsu.cs.maslova_e_i.entity.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl extends DatabaseConfig implements DepartmentDao {
    private static final String INSERT_QUERY = "insert into departments (name) values (?)";
    private static final String UPDATE_QUERY = "update departments set name = ? where id = ?";
    private static final String DELETE_QUERY = "delete from departments where id = ?";
    private static final String GET_DEPART_BY_ID = "select * from departments where id = ?";
    private static final String GET_DEPART_PATIENTS = "SELECT D.NAME AS department_name, P.FULL_NAME as patient_name," +
            " P.AGE, P.GENDER FROM departments D " +
            "JOIN PATIENTS P on D.ID = P.DEPARTMENT_ID";

    @Override
    public int create(Department department) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, department.getName());
            return statement.executeUpdate();
        } catch (SQLException e) {
            //TODO
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int id) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException e) {
            //TODO
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Department department) {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, department.getName());
            statement.setInt(2, department.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            //TODO
            throw new RuntimeException(e);
        }
    }

    @Override
    public Department findById(int id) {
        //TODO not found exception
        Department department = null;

        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(GET_DEPART_BY_ID);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                department = Department.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return department;
    }

    @Override
    public List<Patient> getAllDepartmentPatients() {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(GET_DEPART_PATIENTS);
            List<Patient> patients = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Patient patient = Patient.builder()
                        .id(resultSet.getInt("id"))
                        .fullName(resultSet.getString("full_name"))
                        .age(resultSet.getInt("age"))
                        .gender(resultSet.getString("gender"))
                        .departmentId(resultSet.getInt("department_id"))
                        .build();
                patients.add(patient);
            }
            return patients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
