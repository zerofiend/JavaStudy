package com.cookies;

import com.dao.LoginDao;
import com.dao.impl.LoginDaoImpl;
import com.pojo.T_User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginStudent extends HttpServlet {
    LoginDao loginDao = null;

    public LoginStudent() {
        loginDao = new LoginDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        T_User stu = loginDao.login(uname, pwd);
        if (stu != null) {
//            把数据存储到cookies中
            Cookie cookie = new Cookie("uname1", stu.getUname());
//            设置三天免登录
            cookie.setMaxAge(24 * 3600 * 3);
//            cookies响应到浏览器中
            resp.addCookie(cookie);
            Cookie cookie1 = new Cookie("pwd1", stu.getPwd());
            resp.addCookie(cookie1);
            resp.sendRedirect("success");
        } else {
            req.getRequestDispatcher("login.html").forward(req, resp);
        }
    }
}
