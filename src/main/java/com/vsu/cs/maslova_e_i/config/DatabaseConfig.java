package com.vsu.cs.maslova_e_i.config;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DatabaseConfig {
    @SneakyThrows
    public Connection connect() {
        Class.forName("org.postgresql.Driver");
        String url="jdbc:postgresql://localhost:5432/hospital";
        String username="postgres";
        String password="1234";
        return DriverManager.getConnection(url,username,password);
    }
}
