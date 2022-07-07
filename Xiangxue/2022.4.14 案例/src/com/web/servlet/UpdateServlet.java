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

@WebServlet("/upUser")
public class UpdateServlet extends HttpServlet {
    UserService userService = null;

    public UpdateServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String pwd = req.getParameter("password");
        HttpSession session = req.getSession();
        T_User user = (T_User) session.getAttribute("user");
        int id = user.getId();
        int n = userService.updateUser(id, pwd);
        if (n == 1) {
            resp.getWriter().write("修改成功！");
        } else {
            resp.getWriter().write("修改失败！");
        }
    }
}
