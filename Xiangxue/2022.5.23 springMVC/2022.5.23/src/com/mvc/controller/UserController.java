package com.mvc.controller;

import com.mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    /**
     * 使用整体接收数据
     * 接收前端提交的数据为json格式的字符串
     */
    @RequestMapping(value = "/login", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login(User user) {
        System.out.println(user);
        return "完成";
    }

    /**
     * 可以把提交的数据转换为json格式
     */
    @RequestMapping("/login2")
    @ResponseBody
    public String login2(@RequestBody String json) {
        return json;
    }
}
