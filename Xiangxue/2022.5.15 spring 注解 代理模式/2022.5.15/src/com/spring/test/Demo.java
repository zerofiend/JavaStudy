package com.spring.test;

import com.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
//        正转
        User user = new User();
        user.setUname("张三");
        System.out.println(user);
    }

    //        使用spring控制反转
    @Test
    public void run() {
//        加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//        通过bean标签从spring中调取对象
        User user = (User) ac.getBean("user");
        System.out.println(user);
    }

}
