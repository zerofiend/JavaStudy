package com.servlet;

import com.pojo.T_User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginUser")
public class LoginServlet extends HttpServlet {
    UserService userService = null;

    public LoginServlet() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        T_User user = userService.login(uname, pwd);
        if (user != null) {
            Cookie cookie1 = new Cookie("uname1", user.getUname());
            Cookie cookie2 = new Cookie("pwd1", user.getPwd());
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
            resp.sendRedirect("success");
        } else {
            req.getRequestDispatcher("login.html").forward(req, resp);
        }
    }
}
