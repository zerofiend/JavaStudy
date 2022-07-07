package com.web.pojo;

import java.io.Serializable;

public class T_User implements Serializable {
    private int id;
    private String uname;
    private String pwd;

    public T_User() {
    }

    public T_User(int id, String uname, String pwd) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "T_User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
