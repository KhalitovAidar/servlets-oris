package com.semestr1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String form = "<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + "<link rel=\"stylesheet\" href=\"styles/register.css\">\n" +
                "<title>Регистрация</title>\n" + "</head>\n" + "<body>\n" + "<form action=\"RegistrationServlet\" method=\"post\">\n" +
                "    <input type=\"text\" name=\"username\" placeholder=\"Имя пользователя\" required>\n" + "    <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Пароль\" required>\n" +
                "    <input type=\"password\" name=\"confirmPassword\" placeholder=\"Подтвердите пароль\" required>\n" + "    <button type=\"submit\">Зарегистрироваться</button>\n" + "</form>\n" +
                "</body>\n" + "</html>";

        response.getWriter().println(form);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Обработка введенных данных
    }

    public void destroy() {
    }
}

