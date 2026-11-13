package com.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
@WebFilter("*.action")
public class AFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request1 =  (HttpServletRequest) request;
        //get ip address
        String ipAddress=request1.getRemoteAddr();
        //get resouce name
        String resName=request1.getRequestURI();
        System.out.println("i am watching u :i am filter A" + resName+" : "+ipAddress);

        chain.doFilter(request, response);
    }
}
