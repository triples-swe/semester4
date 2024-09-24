package com.example.controller;

import com.example.model.Car;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getCars")
public class ReadServlet extends HttpServlet {
    private final String FILE_PATH = "/cars.json";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Car> cars = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (file.exists()) {
            cars = objectMapper.readValue(file, new TypeReference<List<Car>>() {});
        } else {
            System.out.println("File not found: " + FILE_PATH);
        }

        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/read.jsp").forward(req, resp);
    }
}