package com.visa.prj.web;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("*.jsp")
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)  request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession ses = req.getSession(false);
        if((ses != null && ses.getAttribute("user") != null) || req.getRequestURI().endsWith("login.jsp")) {
            chain.doFilter(request, response);
        } else  {
            res.sendRedirect("login.jsp");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
