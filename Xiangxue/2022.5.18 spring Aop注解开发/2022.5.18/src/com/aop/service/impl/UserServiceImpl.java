package com.aop.service.impl;

import com.aop.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Override
    public void save() {    /*  在save之前进行功能增强   */
        System.out.println("前置+后置代理");
    }

    @Override
    public String saveBack() {
        System.out.println("带返回值的代理，返回success");
        return "success";
    }

    @Override
    public void delete() {
        System.out.println("环绕代理");
    }

    @Override
    public void delete2(String uname, String pwd) {
        System.out.println("带形式参数的环绕代理");
    }

    /**
     * 在spring中通过这个逻辑来结合mybatis来决定什么时候回滚
     * 不要人为手动捕获异常
     */
    @Override
    public void update() {
        System.out.println("update方法执行");
/*        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        System.out.println(1 / 0);
    }

    @Override
    public void select() {
        System.out.println("select方法执行");
    }
}
