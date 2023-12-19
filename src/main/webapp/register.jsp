<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="WEB-INF/styles/register.css">
    <title>Регистрация</title>
</head>
<body>
<form action="register" method="post">
    <input type="text" name="username" placeholder="Имя пользователя" required>
    <input type="password" name="password" id="password" placeholder="Пароль" required>
    <input type="password" name="confirmPassword" placeholder="Подтвердите пароль" required>
    <button type="submit" onclick="checkPassword()">Зарегистрироваться</button>
</form>
<script>
    function checkPassword() {
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirmPassword").value;

        if (password != confirmPassword) {
            alert("Пароль и подтверждение пароля не совпадают");
            return false;
        }
        return true;
    }
</script>
</body>
</html>