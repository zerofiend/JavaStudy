package com.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*public class MyController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        视图模型对象。用来封装跳转到的页面，和 携带的数据
        ModelAndView view = new ModelAndView();
        view.addObject("uname", "张三");
        view.setViewName("a.jsp");
        return view;
    }
}*/
@Controller //  通过注解直接实现接口
public class MyController {
    @RequestMapping("/abc") //  限定路径名称  /abc--->uri地址
    public String show() {
        /*  默认为请求转发 */
//        return "forward:/a.jsp";    //  请求转发
        return "redirect:/a.jsp";   //  重定向
    }

    @RequestMapping("/aaa")
    public String showHTML() {
        return "/html/a.html";
    }
}
