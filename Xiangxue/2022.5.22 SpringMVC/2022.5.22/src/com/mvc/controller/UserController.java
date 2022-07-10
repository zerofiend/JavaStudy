package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.Arrays;

@Controller
public class UserController {
    @RequestMapping(value = "/login", produces = "text/html;charset=utf-8")
    @ResponseBody   //  加这个注解表示当前返回的是数据而不是页面
    public String loginUser(HttpServletRequest req, HttpServletResponse resp) {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String[] favors = req.getParameterValues("favor");
        System.out.println(uname);
        System.out.println(pwd);
        System.out.println(Arrays.toString(favors));
        return "ok非常好";    //  返回的是数据
    }

    //    使用参数名称逐个接收
    @RequestMapping(value = "/login2", produces = "text/html;charset=utf-8")
    @ResponseBody   //  加这个注解表示当前返回的是数据而不是页面
    /**
     * @RequestParam()用于接收变量，如果参数名与所提交的名称一致则可以忽略
     */
    public String loginUser2(String uname, String pwd,
                             char sex, String[] favor, Date birthday) {
        System.out.println(uname);
        System.out.println(pwd);
        System.out.println(sex);
        System.out.println(Arrays.toString(favor));
        System.out.println(birthday);
        return "ok非常好";    //  返回的是数据
    }

    //    使用参数名称逐个接收
    @RequestMapping(value = "/login3", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody   //  加这个注解表示当前返回的是数据而不是页面
    /**
     * @RequestParam()用于接收变量，如果参数名与所提交的名称一致则可以忽略
     */
    public String loginUser3(@RequestBody String uname, @RequestBody String pwd,
                             @RequestBody char sex,
                             @RequestBody String[] favor, Date birthday) {
        System.out.println(uname);
        System.out.println(pwd);
        System.out.println(sex);
        System.out.println(Arrays.toString(favor));
        System.out.println(birthday);
        return "ok非常好";    //  返回的是数据
    }
}
