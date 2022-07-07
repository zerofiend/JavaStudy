package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/ServletD")
public class ServletD extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        File file = new File("file/a.txt");
        System.out.println(file.getAbsolutePath());
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath);
        String realPath1 = servletContext.getRealPath("/file/a.txt");
        System.out.println(realPath1);
    }
}
