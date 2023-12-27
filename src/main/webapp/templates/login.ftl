<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles/register.css">
    <title>Вход</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="login" method="post" class="mt-5">
                <#if errorMessage??>
                    <p style="color: red;">${errorMessage}</p>
                </#if>
                <#if successMessage??>
                    <p style="color: green;">${successMessage}</p>
                </#if>
                <div class="form-group">
                    <input type="text" name="username" id="username" class="form-control" placeholder="Имя пользователя" required>
                </div>
                <div class="form-group">
                    <input type="password" name="password" id="password" class="form-control" placeholder="Пароль" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Войти</button>
            </form>
        </div>
    </div>
</div>
</body>