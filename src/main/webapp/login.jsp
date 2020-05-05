<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 09.04.2020
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Авторизуйтесь</h2>
<form action="" method="post">
    <input type="text" required placeholder="Login" name="name"><br>
    <input type="password" required placeholder="Password" name="password"><br><br>
    <input type="submit" value="Войти"><br><br>
    ${message}
</form>
</body>
</html>

