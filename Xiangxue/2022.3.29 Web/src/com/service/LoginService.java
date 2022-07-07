package com.service;

import com.dao.UserDao;
import com.dao.impl.ImplUserDao;
import com.pojo.T_User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginUser")
public class LoginService extends HttpServlet {
    private UserDao userDao;

    public LoginService() {
        userDao = new ImplUserDao();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println("uname = " + uname + "\tpwd = " + pwd);
        T_User user = userDao.login(uname, pwd);
        if (user != null) {
//            resp.getWriter().write("登录成功！");
//            req.getRequestDispatcher("success.html").forward(req, resp);
            resp.sendRedirect("success.html");
        } else {
            resp.getWriter().write("登录失败！");
        }
    }
}
