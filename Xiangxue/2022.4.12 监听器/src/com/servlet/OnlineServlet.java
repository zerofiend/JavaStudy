package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/online")
public class OnlineServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        Integer onlineNumber = (Integer) session.getServletContext().getAttribute("onlineNumber");
        resp.getWriter().write("<h2>当前在线有" + onlineNumber + "人</h2>");
        resp.getWriter().write("<a href='online?key=logout'>退出</a>");
        String key = req.getParameter("key");
        if ("logout".equals(key)) {
            session.invalidate();
        }
    }
}
