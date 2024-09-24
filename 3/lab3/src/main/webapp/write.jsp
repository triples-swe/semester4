<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Добавить автомобиль</title>
    <link rel="stylesheet" href="write.css">
</head>
<body>
<h1>Добавить новый автомобиль</h1>
<form action="/addCar" method="post">
    <input type="text" name="brand" placeholder="Марка" required>
    <input type="text" name="model" placeholder="Модель" required>
    <input type="number" name="year" placeholder="Год" required>
    <input type="text" name="color" placeholder="Цвет" required>
    <input type="text" name="bodyType" placeholder="Тип кузова" required>
    <input type="number" name="mileage" placeholder="Пробег" required>
    <input type="text" name="engineType" placeholder="Тип двигателя" required>
    <button type="submit">Добавить автомобиль</button>
</form>
<a href="/getCars">Вернуться к списку автомобилей</a>
</body>
</html>
