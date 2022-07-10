package com.aop.test;

import com.aop.pojo.CUser;
import com.aop.service.AccountService;
import com.aop.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    ApplicationContext ac;

    public Demo() {
        ac = new ClassPathXmlApplicationContext("spring.xml", "mybatis.xml", "aspect.xml", "transact.xml");
    }

    @Test
    public void login() {
        UserServiceImpl userService = (UserServiceImpl) ac.getBean("userServiceImpl");
        CUser user = userService.loginUser("张三", "123");
        if (user != null) {
            System.out.println("登陆成功，欢迎" + user.getUname() + "登录");
        } else {
            System.out.println("登录失败");
        }
    }

    @Test
    public void transfer() {
        /*  Aop的底层动态代理，这里需要使用接口的引用指向接口的实现   */
        AccountService accountService = (AccountService) ac.getBean("accountServiceImpl");
        int n = accountService.transferAccount(1, 2, 500);
        /*  使用spring整合mybatis   */
        System.out.println(n == 1 ? "转账成功" : "转账失败");
    }
}
