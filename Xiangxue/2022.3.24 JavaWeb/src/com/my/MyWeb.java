package com.my;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/webServlet")
public class MyWeb extends HttpServlet {
/*    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
    }*/

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*乱码修改*/
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        System.out.println("service");
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println(uname + "-----" + pwd);
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }
}
