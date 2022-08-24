package com.my.passport.controller;

import com.my.passport.service.UserService;
import com.my.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String loginUser(String uname, String pwd, HttpSession session) {
        User login = userService.login(uname, pwd);
        if (login != null) {
            session.setAttribute("user", login);
            return "redirect:/success";
        }
        return "redirect:/fail";
    }
}
