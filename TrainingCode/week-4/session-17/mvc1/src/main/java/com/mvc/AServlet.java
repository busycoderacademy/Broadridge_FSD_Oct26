package com.mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
@WebServlet("/a.action")
public class AServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("inside servlet A");
//        RequestDispatcher rd = req.getRequestDispatcher("b.action");
//        req.setAttribute("data","this is some imp data");
//        rd.forward(req, resp);
//        String val=this.getServletContext().getInitParameter("cn");
//        resp.sendRedirect("b");
    }
}
