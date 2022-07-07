package com.servlet;

import com.pojo.T_User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/success")
public class Success extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        T_User user = (T_User) session.getAttribute("user");
        resp.getWriter().write("欢迎" + user.getUname() + "登录成功");
        resp.getWriter().write("<a href='exit'>退出</a>");

    }
}
