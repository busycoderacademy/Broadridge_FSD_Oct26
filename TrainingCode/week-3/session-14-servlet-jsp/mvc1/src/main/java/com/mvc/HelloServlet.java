package com.mvc;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloServlet extends HttpServlet {

    public HelloServlet(){
        System.out.println("ctr");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String email=config.getInitParameter("email");

        System.out.println("init method "+ email);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String currentDateTime=new Date().toString();
        out.println("<h1>Hello World!</h1>: "+ currentDateTime);
        System.out.println("------------inside doGet-----------");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
