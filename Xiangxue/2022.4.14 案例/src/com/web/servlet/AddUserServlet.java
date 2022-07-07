package com.web.servlet;

import com.web.service.UserService;
import com.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    UserService userService = null;

    public AddUserServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");
        int n = userService.addUser(uname, pwd);
        if (n == 1) {
            PrintWriter out = resp.getWriter();
            String pr = "<script>alert('新增成功！');window.location.href='ShowUsers'</script>";
            out.print(pr);
        } else {
            PrintWriter out = resp.getWriter();
            String pr = "<script>alert('新增失败！');window.location.href='ShowUsers'</script>";
            out.print(pr);
        }
    }
}
