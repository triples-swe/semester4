package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet("/trigonometry")
public class TrigonometryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получение параметров формы
        String angleStr = request.getParameter("angle");
        String unit = request.getParameter("unit");
        String function = request.getParameter("function");
        int precision = Integer.parseInt(request.getParameter("precision"));

        try {
            // Преобразование угла в double
            double angle = Double.parseDouble(angleStr);

            // Если градусы, преобразуем в радианы
            if ("degrees".equals(unit)) {
                angle = Math.toRadians(angle);
            }

            // Вычисление тригонометрической функции
            double result = 0;
            switch (function) {
                case "sin":
                    result = Math.sin(angle);
                    break;
                case "cos":
                    result = Math.cos(angle);
                    break;
                case "tan":
                    result = Math.tan(angle);
                    break;
            }

            // Форматирование результата с учетом указанной точности
            String formatPattern = "#." + "#".repeat(precision);
            DecimalFormat df = new DecimalFormat(formatPattern);
            String formattedResult = df.format(result);

            // Установка атрибутов и перенаправление на JSP для отображения
            request.setAttribute("result", formattedResult);
            request.setAttribute("angle", angleStr);
            request.setAttribute("function", function);
            request.getRequestDispatcher("result.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Некорректное значение угла.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}