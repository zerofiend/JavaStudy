package com.service;

import com.pojo.T_User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/handlerServlet")
public class HandlerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        T_User user = (T_User) req.getAttribute("user");
        resp.getWriter().write("<h1>系统提示</h1>");
        resp.getWriter().write("<hr/>");
        resp.getWriter().write("<font color='blue'>欢迎" + user.getUname() + "登录成功！</font>");
    }
}
