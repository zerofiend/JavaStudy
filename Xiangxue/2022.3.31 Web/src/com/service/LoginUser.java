package com.service;

import com.dao.LoginDao;
import com.dao.impl.LoginDaoImpl;
import com.pojo.T_User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginUser")
public class LoginUser extends HttpServlet {
    LoginDao loginDao = null;

    public LoginUser() {
        loginDao = new LoginDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        T_User login = loginDao.login(uname, pwd);
        if (login != null) {
//            resp.sendRedirect("success.html");
            req.setAttribute("user", login);
            req.getRequestDispatcher("handlerServlet").forward(req, resp);
        } else {
            req.getRequestDispatcher("login.html").forward(req, resp);
        }
    }
}
