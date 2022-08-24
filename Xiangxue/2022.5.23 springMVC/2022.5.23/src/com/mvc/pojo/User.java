package com.mvc.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

public class User implements Serializable {
    private String uname;
    private String pwd;
    private String sex;
    private String[] favor;
    private java.sql.Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                ", favor=" + Arrays.toString(favor) +
                ", birthday=" + birthday +
                '}';
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String[] getFavor() {
        return favor;
    }

    public void setFavor(String[] favor) {
        this.favor = favor;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
