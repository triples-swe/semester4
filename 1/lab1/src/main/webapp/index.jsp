<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Тригонометрические функции</title>
</head>
<body>
<h2>Вычисление тригонометрических функций</h2>
<form action="trigonometry" method="post">
    <label for="angle">Угол:</label>
    <input type="text" id="angle" name="angle" required><br>

    <label for="unit">Единица измерения:</label>
    <select id="unit" name="unit">
        <option value="degrees">Градусы</option>
        <option value="radians">Радианы</option>
    </select><br>

    <label for="function">Функция:</label>
    <select id="function" name="function">
        <option value="sin">Синус</option>
        <option value="cos">Косинус</option>
        <option value="tan">Тангенс</option>
    </select><br>

    <label for="precision">Точность (знаков после запятой):</label>
    <input type="number" id="precision" name="precision" min="0" required><br>

    <input type="submit" value="Вычислить">
</form>
</body>
</html>