package com.spring.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;

    private String uname;

    private String pwd;
    private Accout accout;

    public Accout getAccout() {
        return accout;
    }

    public void setAccout(Accout accout) {
        this.accout = accout;
    }

    private static final long serialVersionUID = 1L;
    private Class aClass;

    public User() {

    }

    public User(Integer id, String uname, String pwd, Class aClass) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
        this.aClass = aClass;
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
        this.uname = uname == null ? null : uname.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", accout=" + accout +
                ", aClass=" + aClass +
                '}';
    }
}
