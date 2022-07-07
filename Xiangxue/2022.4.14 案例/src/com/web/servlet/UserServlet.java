package com.web.servlet;

import com.web.pojo.T_User;
import com.web.service.UserService;
import com.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginUser")
public class UserServlet extends HttpServlet {
    UserService userService = null;

    public UserServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        T_User t_user = userService.loginUser(uname, pwd);
        if (t_user != null) {
//            登陆成功  信息存储到session中
            HttpSession session = req.getSession();
            session.setAttribute("user", t_user);
//            跳转到后台主页
            resp.sendRedirect("main.jsp");
        } else {
//            登陆失败
            req.setAttribute("msg", "用户名或密码输入错误！");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
