package com.mvc;

import com.model.BookAdviser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/SelectBook.action")
public class SelectBookController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String topic=req.getParameter("topic");
        List<String> booksName= BookAdviser.bookAdviser(topic);

        //somehow i want to use the view layer but i need to pass something to him
        req.setAttribute("books",booksName);
        RequestDispatcher rd = req.getRequestDispatcher("/result.jsp");
        rd.forward(req,resp);

    }
}
