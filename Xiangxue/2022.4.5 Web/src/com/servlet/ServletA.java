package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*ServletContext servletContext1 = this.getServletContext();
        ServletContext servletContext2 = req.getServletContext();
        ServletContext servletContext3 = this.getServletConfig().getServletContext();
        System.out.println(servletContext1.hashCode());
        System.out.println(servletContext2.hashCode());
        System.out.println(servletContext3.hashCode());*/
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("a", "abc");
        servletContext.setAttribute("b", "123");
    }
}
