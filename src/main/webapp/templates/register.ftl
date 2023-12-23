<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles/register.css">
    <title>Регистрация</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="register" method="post" class="mt-5">
                <#if errorMessage??>
                    <p style="color: red;">${errorMessage}</p>
                </#if>
                <div class="form-group">
                    <input type="text" name="username" id="username" class="form-control" placeholder="Имя пользователя" pattern=".{3,20}" title="Имя пользователя должно содержать от 3 до 20 символов." required>
                </div>
                <div class="form-group">
                    <input type="password" name="password" id="password" class="form-control" placeholder="Пароль" pattern="(?=.*\d)(?=.*[a-zA-Zа-яА-Я]).{6,}" title="Пароль должен содержать как минимум одну цифру и один обычный символ, и быть не менее 6 символов в длину." required>
                </div>
                <div class="form-group">
                    <input type="password" name="confirmPassword" class="form-control" placeholder="Подтвердите пароль" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Зарегистрироваться</button>
                <div class="mt-3">
                    <p>Уже есть аккаунт? <a href="login" class="btn btn-link">Вход</a></p>
                </div>
            </form>
        </div>
    </div>
</div>
</body>