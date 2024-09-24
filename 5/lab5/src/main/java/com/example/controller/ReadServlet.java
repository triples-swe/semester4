package com.example.controller;

import com.example.config.DatabaseConnection;
import com.example.model.Car;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getCars")
public class ReadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM cars";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Car car = new Car();
                    car.setId(rs.getInt("id"));
                    car.setBrand(rs.getString("brand"));
                    car.setModel(rs.getString("model"));
                    car.setYear(rs.getInt("year"));
                    car.setColor(rs.getString("color"));
                    car.setBodyType(rs.getString("body_type"));
                    car.setMileage(rs.getInt("mileage"));
                    car.setEngineType(rs.getString("engine_type"));
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (!resp.isCommitted()) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ошибка подключения к базе данных");
            }
            return;
        }

        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/read.jsp").forward(req, resp);
    }
}