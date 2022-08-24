package com.mvc.controller;

import com.mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.Arrays;

@Controller
@RequestMapping("/user")    /*  在类上加上这个注解就是给所有以下的路径名加上了一个一级路径    */
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

    /**
     * 整体接收数据
     */

    @RequestMapping(value = "/login4", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public String loginUser4(User user) {
        System.out.println(user);
        return user.getUname();
    }

    @RequestMapping(value = "/login5/{username}/{pwd}", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String loginUser5(@PathVariable String username, @PathVariable String pwd) {
        System.out.println(username);
        System.out.println(pwd);
        return "非常好";
    }

    @RequestMapping(value = "/login6", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String loginUser6(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "非常好";
    }

    @RequestMapping("/showData")
    public String showData(Model model) {
        model.addAttribute("name", "张三");
        model.addAttribute("age", "12");
        return "/b.jsp";
    }

    /**
     * 在controller中的方法通过url互相访问
     */
    @RequestMapping("/showData2")
    public String showData2() {
        return "/user/showData";
    }

    /**
     * 跨域访问
     */
    @RequestMapping("/showData3")
    public String showData3() {
        return "redirect:https://www.baidu.com";    //  可以通过重定向
//        return "forward:https://www.baidu.com"; //  不可以通过请求转发
    }

    /**
     * 跨域访问
     */
    @RequestMapping("/showData4")
    public ModelAndView showData4() {
        ModelAndView modelAndView = new ModelAndView(new RedirectView("https://www.taobao.com"));
        return modelAndView;
    }
}
