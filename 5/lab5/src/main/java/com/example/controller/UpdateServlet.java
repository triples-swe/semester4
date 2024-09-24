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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/updateCar")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Некорректный ID автомобиля");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Некорректный ID автомобиля");
            return;
        }

        Car car = new Car();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM cars WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    car.setId(rs.getInt("id"));
                    car.setBrand(rs.getString("brand"));
                    car.setModel(rs.getString("model"));
                    car.setYear(rs.getInt("year"));
                    car.setColor(rs.getString("color"));
                    car.setBodyType(rs.getString("body_type"));
                    car.setMileage(rs.getInt("mileage"));
                    car.setEngineType(rs.getString("engine_type"));
                } else {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Автомобиль не найден");
                    return;
                }
                req.setAttribute("car", car);
                req.getRequestDispatcher("/update.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ошибка подключения к базе данных");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Некорректный ID автомобиля");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Некорректный ID автомобиля");
            return;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE cars SET brand = ?, model = ?, year = ?, color = ?, body_type = ?, mileage = ?, engine_type = ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, req.getParameter("brand"));
                pstmt.setString(2, req.getParameter("model"));
                pstmt.setInt(3, Integer.parseInt(req.getParameter("year")));
                pstmt.setString(4, req.getParameter("color"));
                pstmt.setString(5, req.getParameter("bodyType"));
                pstmt.setInt(6, Integer.parseInt(req.getParameter("mileage")));
                pstmt.setString(7, req.getParameter("engineType"));
                pstmt.setInt(8, id);
                pstmt.executeUpdate();
                resp.sendRedirect("/getCars");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ошибка подключения к базе данных");
        }
    }
}