package com.semestr1;

import com.semestr1.dto.quote.QuoteRequest;
import com.semestr1.dto.user.UserRequest;
import com.semestr1.exception.quote.CanNotCreateQuoteException;
import com.semestr1.exception.user.UserNotFoundException;
import com.semestr1.model.Quote;
import com.semestr1.model.User;
import com.semestr1.repository.QuoteRepository;
import com.semestr1.repository.UserRepository;
import com.semestr1.service.QuoteService;
import com.semestr1.service.UserService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "profile", value = "/profile")
public class ProfileServlet extends HttpServlet {
    private Configuration cfg;
    private QuoteService quoteService;
    private UserService userService;

    public void init() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setDefaultEncoding("UTF-8");
        this.cfg = cfg;
        this.quoteService = new QuoteService(new QuoteRepository());
        this.userService = new UserService(new UserRepository());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        ServletContext servletContext = getServletContext();
        File templateDir = new File(servletContext.getRealPath("/templates"));
        cfg.setDirectoryForTemplateLoading(templateDir);
        Template template = cfg.getTemplate("profile.ftl");

        Map<String, Object> input = new HashMap<>();

        String errorMessage = (String)request.getAttribute("errorMessage");

        if(errorMessage != null && !errorMessage.isEmpty()) {
            input.put("errorMessage", errorMessage);
        }

        String successMessage = (String)request.getAttribute("successMessage");

        if(successMessage != null && !successMessage.isEmpty()) {
            input.put("successMessage", successMessage);
        }

        HttpSession session = request.getSession(false);

        input.put("username", session.getAttribute("username"));

        UserRequest userRequest = new UserRequest((String)session.getAttribute("username"), (String)session.getAttribute("password"));

        try {
            User user = userService.getUser(userRequest);
            List<Quote> usersQuotes = quoteService.getQuotesByUserId(user.getUuid());
            input.put("usersQuotes", usersQuotes);

        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (PrintWriter out = response.getWriter()) {
            if (session.getAttribute("username") != null && session.getAttribute("password") != null) {
                template.process(input, out);
            } else {
                response.sendRedirect(request.getContextPath() + "/register");
                return;
            }
        } catch (TemplateException e) {
            throw new ServletException("Error while processing FreeMarker template", e);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        UserRequest userRequest = new UserRequest((String)session.getAttribute("username"), (String)session.getAttribute("password"));

        userService.delete(userRequest);
        response.sendRedirect(request.getContextPath() + "/register");
    }
}