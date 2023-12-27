<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quote Details</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<#include "navbar.ftl">
<div class="container mt-5">
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <div class="card">
                <div class="card-header">
                    Quote Details
                </div>
                <div class="card-body">
                    <h5 class="card-title">Quote:</h5>
                    <p class="card-text">${quote.text}</p>
                    <p class="card-text">Author: ${quote.author.getName()}</p>
                    <p class="card-text">Created: ${quote.createdTime}</p>
<#--                    <p class="card-text">Likes: ${quote.likes}</p>-->
<#--                    <p class="card-text">Dislikes: ${quote.dislikes}</p>-->
                </div>
            </div>
        </div>
    </div>

    <div class="row mt-4">
        <div class="col-md-8 offset-md-2">
            <div class="card">
                <div class="card-header">
                    Comments
                </div>
                <ul class="list-group list-group-flush">
                    <#list comments as comment>
                        <li class="list-group-item">${comment.text}</li>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>