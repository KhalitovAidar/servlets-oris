package com.semestr1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/dislikeServlet")
public class DislikeServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Получите идентификатор цитаты из запроса
//        String quoteId = request.getParameter("quoteId");
//
//        // Используйте полученный идентификатор цитаты для обновления дизлайков в вашей базе данных
//
//        // Отправьте обновленное количество дизлайков в качестве ответа на AJAX-запрос
//        int updatedDislikes = ...; // Получите обновленное количество дизлайков
//        response.getWriter().write(String.valueOf(updatedDislikes));
//    }
}
