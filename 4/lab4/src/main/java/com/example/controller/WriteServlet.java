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

@WebServlet("/addCar")
public class WriteServlet extends HttpServlet {
    private final String FILE_PATH = "/cars.json";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/write.jsp").forward(req, resp);
    }

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Извлечение параметров формы
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        int year = Integer.parseInt(req.getParameter("year"));
        String color = req.getParameter("color");
        String bodyType = req.getParameter("bodyType");
        int mileage = Integer.parseInt(req.getParameter("mileage"));
        String engineType = req.getParameter("engineType");

        // Создание нового объекта Car
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(year);
        car.setColor(color);
        car.setBodyType(bodyType);
        car.setMileage(mileage);
        car.setEngineType(engineType);

        // Чтение текущего массива автомобилей
        List<Car> cars = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (file.exists()) {
            cars = objectMapper.readValue(file, new TypeReference<List<Car>>() {});
        }

        // Добавление нового автомобиля и запись обратно в файл
        cars.add(car);
        objectMapper.writeValue(new File(FILE_PATH), cars);

        // Перенаправление на страницу со списком автомобилей
        resp.sendRedirect("/getCars");
    }
}