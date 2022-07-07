package com.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/success")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        通过浏览器请求中携带的cookies中提取内容
        Cookie[] cookies = req.getCookies();
        String uname = null;
        String pwd = null;
        for (Cookie c : cookies) {
            if ("uname1".equals(c.getName())) {
                uname = c.getValue();
                System.out.println("uname = " + uname);
            }
            if ("pwd1".equals(c.getName())) {
                pwd = c.getValue();
                System.out.println("pwd = " + pwd);
            }
        }
        resp.getWriter().write("<h1>系统提示</h1>");
        resp.getWriter().write("<hr/>");
        resp.getWriter().write("<font color='blue'>欢迎" + uname + "登录成功！</font>");
    }
}
