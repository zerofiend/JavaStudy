package com.web.servlet;

import com.web.pojo.T_User;
import com.web.service.UserService;
import com.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowUsers")
public class ShowServlet extends HttpServlet {
    private UserService userService = null;

    public ShowServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<T_User> t_users = userService.showAll();
        req.setAttribute("t_users", t_users);
        req.getRequestDispatcher("showUsers.jsp").forward(req, resp);
    }
}
