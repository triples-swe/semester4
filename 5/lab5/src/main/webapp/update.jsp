<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Редактировать автомобиль</title>
    <link rel="stylesheet" href="update.css">
</head>
<body>
<h1>Редактировать автомобиль</h1>
<form action="/updateCar" method="post">
    <input type="hidden" name="id" value="${car.id}">
    <input type="text" name="brand" value="${car.brand}" required>
    <input type="text" name="model" value="${car.model}" required>
    <input type="number" name="year" value="${car.year}" required>
    <input type="text" name="color" value="${car.color}" required>
    <input type="text" name="bodyType" value="${car.bodyType}" required>
    <input type="number" name="mileage" value="${car.mileage}" required>
    <input type="text" name="engineType" value="${car.engineType}" required>
    <button type="submit">Обновить автомобиль</button>
</form>
<a href="/getCars">Вернуться к списку автомобилей</a>
</body>
</html>
