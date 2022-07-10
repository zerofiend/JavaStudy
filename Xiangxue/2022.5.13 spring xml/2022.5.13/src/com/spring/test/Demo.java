package com.spring.test;

import com.spring.pojo.Data;
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

        System.out.println("--------------------");
        User user2 = (User) ac.getBean("user2");
        System.out.println(user2);
    }

    /*
        调取特殊类型的对象
     */
    @Test
    public void run2() {
        //        加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Data data = (Data) ac.getBean("data");
        System.out.println(data);
    }
}
