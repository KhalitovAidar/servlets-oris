package com.semestr1.semestr1;

import com.semestr1.semestr1.dto.UserRequest;
import com.semestr1.semestr1.repository.UserRepository;
import com.semestr1.semestr1.service.UserService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "register", value = "/register")
public class RegistrationServlet extends HttpServlet {
    private Configuration cfg;
    private UserService userService;
    public void init() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setDefaultEncoding("UTF-8");
        this.cfg = cfg;
        this.userService = new UserService(new UserRepository());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        ServletContext servletContext = getServletContext();
        File templateDir = new File(servletContext.getRealPath("/templates"));
        cfg.setDirectoryForTemplateLoading(templateDir);
        Template template = cfg.getTemplate("register.ftl");

        Map<String, Object> input = new HashMap<>();

        String errorMessage = (String)request.getAttribute("errorMessage");
        if(errorMessage != null && !errorMessage.isEmpty()) {
            input.put("errorMessage", errorMessage);
        }

        try (PrintWriter out = response.getWriter()) {
            template.process(input, out);
        } catch (TemplateException e) {
            throw new ServletException("Error while processing FreeMarker template", e);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Пароли не совпадают. Пожалуйста, введите пароли заново.");
            doGet(request, response);
            return;
        }

        UserRequest userRequest = new UserRequest(username, password);
        userService.getUserByUserRequest(userRequest);
    }
}