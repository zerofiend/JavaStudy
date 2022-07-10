package com.aop.service;

public interface UserService {
    public void save();

    public String saveBack();

    public void delete();

    public void delete2(String uname, String pwd);

    public void update();

    public void select();
}
