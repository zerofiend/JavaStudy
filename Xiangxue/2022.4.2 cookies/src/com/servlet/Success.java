package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/success")
public class Success extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        String uname = null, pwd = null;
        if (cookies != null) {
            System.out.println(Arrays.toString(cookies));
            for (Cookie cookie : cookies) {
                if ("uname1".equals(cookie.getName())) {
                    uname = cookie.getValue();
                    System.out.println("uname = " + uname);
                }
                if ("pwd1".equals(cookie.getName())) {
                    pwd = cookie.getValue();
                    System.out.println("pwd = " + pwd);
                }
            }
        }
        resp.getWriter().write("<h1>系统提示</h1>");
        resp.getWriter().write("<hr/>");
        resp.getWriter().write("<h3>欢迎" + uname + "登录成功</h3>");
    }
}
