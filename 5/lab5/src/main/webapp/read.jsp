<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Car" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список автомобилей</title>
    <link rel="stylesheet" href="read.css">
</head>
<body>
<h1>Список автомобилей</h1>
<table>
    <thead>
    <tr>
        <th>Марка</th>
        <th>Модель</th>
        <th>Год</th>
        <th>Цвет</th>
        <th>Тип кузова</th>
        <th>Пробег (км)</th>
        <th>Тип двигателя</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Car> cars = (List<Car>) request.getAttribute("cars");
        if (cars != null && !cars.isEmpty()) {
            for (int i = 0; i < cars.size(); i++) {
                Car car = cars.get(i);
    %>
    <tr>
        <td><%= car.getBrand() %></td>
        <td><%= car.getModel() %></td>
        <td><%= car.getYear() %></td>
        <td><%= car.getColor() %></td>
        <td><%= car.getBodyType() %></td>
        <td><%= car.getMileage() %></td>
        <td><%= car.getEngineType() %></td>
        <td>
            <a href="/updateCar?id=<%= car.getId() %>">Редактировать</a>
            <form action="/deleteCar" method="post" style="display:inline;">
                <input type="hidden" name="id" value="<%= car.getId() %>">
                <button type="submit" class="delete-button">Удалить</button>
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="8">Автомобили не найдены.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<a href="/addCar">Добавить новый автомобиль</a>
</body>
</html>
