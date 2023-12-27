package com.semestr1;

import com.semestr1.dto.user.UserRequest;
import com.semestr1.exception.user.UserNotFoundException;
import com.semestr1.model.User;
import com.semestr1.repository.QuoteRepository;
import com.semestr1.repository.UserRepository;
import com.semestr1.service.LikeService;
import com.semestr1.service.QuoteService;
import com.semestr1.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/likeServlet")
public class LikeServlet extends HttpServlet {
    private QuoteService quoteService;
    private UserService userService;
    private LikeService likeService;
    public void init() {
        this.userService = new UserService(new UserRepository());
        this.quoteService = new QuoteService(new QuoteRepository());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quoteId = request.getParameter("quoteId");

        HttpSession session = request.getSession(false);
        UserRequest userRequest = new UserRequest((String) session.getAttribute("username"), (String) session.getAttribute("password"));

        try {
            User user = userService.getUser(userRequest);
            likeService.like(UUID.fromString(quoteId), user.getUuid());
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
