package com.aop.test;

import com.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml", "aspect.xml");

        UserService userService = (UserService) ac.getBean("userServiceImpl");
        userService.save();
        System.out.println("----------------------");
        userService.saveBack();
        System.out.println("----------------------");
        userService.delete();
        System.out.println("----------------------");
        userService.delete2("张三", "123");
        System.out.println("----------------------");
        userService.update();
    }
}
