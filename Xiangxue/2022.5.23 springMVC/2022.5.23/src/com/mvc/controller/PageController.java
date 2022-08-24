package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/WEB-INF/jsp")
public class PageController {
    /*  在WEB-INF目录下的资源不能直接访问，需要通过controller间接实现页面跳转 */
    @RequestMapping("/showA")
    public String showA() {
        return "/WEB-INF/jsp/a.jsp";
    }

    /*    *//*  动态实现传地址 *//*
    @RequestMapping("/showB/{page}")
    public String showPage(@PathVariable String page) {
        return "/WEB-INF/jsp/" + page + ".jsp";
    }*/
    /*  动态实现传地址 */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;    //  自动关联到配置文件中的视图解析器，自动加上前缀和后缀
    }
}
