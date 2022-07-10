package com.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;

/*
    @Component这个注解时告诉spring容器扫描这个类时捕捉所有的类
 */
@Component("user")
@Scope("prototype")     /*  这个注解默认是singleton    */
public class User implements Serializable {
    private Integer id;

    @Value("张三")    //  底层调用set方法
    private String uname;

    private String pwd;
    //    @Autowired    /*  spring的注解   */
//    @Resource   /*  jdk自带的注解    */
//    @Autowired
//    @Qualifier("class")   /*  根据名称注入  */
    @Autowired
    @Qualifier("class1")
    private Class aClass;

    public User() {
    }

    public User(Integer id, String uname, String pwd, Class aClass) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
        this.aClass = aClass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", aClass=" + aClass +
                '}';
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
