<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Профиль пользователя</title>
    <style>
        .delete-account-btn {
            background-color: #dc3545;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }
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
    </style>
</head>
<body>
<#include "navbar.ftl">
<div class="container">
    <h1 style="margin: 20px 0 40px 0">Цитаты пользователя: ${username}</h1>
    <#if usersQuotes??>
        <div class="row">
            <#list usersQuotes as quote>
                <div class="col-md-6">
                    <div class="quote-card">
                        <p>${quote.text}</p>
<#--                        <div>-->
<#--                            <span class="thumb-up" onclick="likeQuote('${quote.uuid}')">&#x1F44D; ${quote.likes}</span>-->
<#--                            <span class="thumb-down" onclick="dislikeQuote('${quote.uuid}')">&#x1F44E; ${quote.dislikes}</span>-->
<#--                        </div>-->
                    </div>
                </div>
            </#list>
        </div>
    <#else>
        <p>Пользователь не добавил цитат</p>
    </#if>
    <form action="profile" method="post">
        <button class="delete-account-btn">Удалить аккаунт</button>
    </form>
</div>
</body>
</html>