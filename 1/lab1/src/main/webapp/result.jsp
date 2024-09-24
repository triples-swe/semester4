<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результат вычисления</title>
</head>
<body>
<h2>Результат</h2>

<p>Угол: <%= request.getAttribute("angle") %></p>
<p>Функция: <%= request.getAttribute("function") %></p>
<p>Результат: <%= request.getAttribute("result") %></p>

<a href="index.jsp">Назад</a>
</body>
</html>