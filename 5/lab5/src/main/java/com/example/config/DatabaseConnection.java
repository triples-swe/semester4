package com.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5433/car_database";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL JDBC Driver не найден.", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}