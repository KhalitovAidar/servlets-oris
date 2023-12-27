package com.semestr1;

import com.semestr1.dto.quote.QuoteResponse;
import com.semestr1.model.Quote;
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

@WebServlet(name = "home", value = "/home")
public class HomeServlet extends HttpServlet {
    private Configuration cfg;
    private QuoteService quoteService;
    @Override
    public void init() throws ServletException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setDefaultEncoding("UTF-8");
        this.cfg = cfg;
        this.quoteService = new QuoteService(new QuoteRepository());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        ServletContext servletContext = getServletContext();
        File templateDir = new File(servletContext.getRealPath("/templates"));
        cfg.setDirectoryForTemplateLoading(templateDir);
        Template template = cfg.getTemplate("home.ftl");

        List<Quote> quoteList = quoteService.getAll();

        Map<String, Object> input = new HashMap<>();

        input.put("quotes", quoteList);

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("username") != null && session.getAttribute("password") != null) {
                template.process(input, out);
            } else {
                response.sendRedirect(request.getContextPath() + "/register");
                return;
            }
        } catch (TemplateException e) {
            throw new ServletException("Error while processing FreeMarker template", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}