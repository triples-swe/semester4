package com.example.controller;

import com.example.config.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/addCar")
public class WriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/write.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO cars (brand, model, year, color, body_type, mileage, engine_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, req.getParameter("brand"));
                pstmt.setString(2, req.getParameter("model"));
                pstmt.setInt(3, Integer.parseInt(req.getParameter("year")));
                pstmt.setString(4, req.getParameter("color"));
                pstmt.setString(5, req.getParameter("bodyType"));
                pstmt.setInt(6, Integer.parseInt(req.getParameter("mileage")));
                pstmt.setString(7, req.getParameter("engineType"));
                pstmt.executeUpdate();
                resp.sendRedirect("/getCars");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ошибка подключения к базе данных");
        }
    }
}
