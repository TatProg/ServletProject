<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 09.04.2020
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<h1>Hello ${user.name}</h1><br>

<form action="/setCookie" method="post">
    <label>
        Введите сообщение:
        <input type="text" required name="message">
    </label>
    <input type="submit" value="Отправить">
</form>
${message}
<br><br>
<a href="/upload">Загрузить файл</a>
<br><br>
<a href="/image">Рисунок</a>
<br><br>
<a href="/logout">Выйти</a>
</body>
</html>