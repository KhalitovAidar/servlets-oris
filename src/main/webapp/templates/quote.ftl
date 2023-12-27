<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles/register.css">
    <title>Создание цитаты</title>
</head>
<body>
<#include "navbar.ftl">
<div class="container">
    <h1 style="margin: 20px 0 40px 0">Создать новую цитату</h1>
    <form action="create-quote" method="post">
        <#if errorMessage??>
            <p style="color: red;">${errorMessage}</p>
        </#if>
        <#if successMessage??>
            <p style="color: green;">${successMessage}</p>
        </#if>
        <div class="form-group">
            <label for="quoteText">Текст цитаты:</label>
            <textarea class="form-control" id="quoteText" name="quote" rows="3" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Создать цитату</button>
    </form>
</div>
</body>
</html>