<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles/register.css">
    <style>
        .quote-card {
            margin-bottom: 20px;
            padding: 15px;
            border: 1px solid #e0e0e0;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .thumb-up, .thumb-down {
            cursor: pointer;
        }
        .navbar {
            margin-bottom: 40px;
        }
    </style>
    <title>Домашняя страница</title>
</head>
<body>

<#include "navbar.ftl">

<div class="container">
    <h1 style="margin: 20px 0 40px 0">ГЛАВНАЯ СТРАНИЦА</h1>
    <#if quotes??>
        <div class="row">
            <#list quotes as quote>
                    <div class="col-md-6">
                            <div class="quote-card">
                                <p>${quote.text}</p>
                                <p><strong>Автор:</strong> ${quote.author.getName()}</p>
<#--                                <div>-->
<#--                                    <span class="thumb-up" onclick="likeQuote(${quote.uuid})">&#x1F44D; ${quote.likes}</span>-->
<#--                                    <span class="thumb-down" onclick="dislikeQuote(${quote.uuid})">&#x1F44E; ${quote.dislikes}</span>-->
<#--                                </div>-->
                                <div class="text-center mt-3">
                                    <a class="btn btn-primary" href="/quote/${quote.uuid}">Перейти к цитате</a>
                                </div>
                            </div>
                    </div>
            </#list>
        </div>
    <#else>
        <p>Нет доступных записей</p>
    </#if>
</div>

<script>
    function likeQuote(quoteId) {
        // Сюда добавьте код для отправки запроса на сервер для увеличения числа лайков для данной цитаты
        // Можно использовать Fetch API или другие методы для отправки запроса
    }

    function dislikeQuote(quoteId) {
        // Сюда добавьте код для отправки запроса на сервер для увеличения числа дизлайков для данной цитаты
        // Можно использовать Fetch API или другие методы для отправки запроса
    }
</script>
</body>
</html>