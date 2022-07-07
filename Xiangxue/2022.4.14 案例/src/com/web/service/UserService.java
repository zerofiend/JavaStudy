package com.web.service;

import com.web.pojo.T_User;

import java.util.List;

public interface UserService {
    public T_User loginUser(String uname, String pwd);

    public int addUser(String uname, String pwd);

    public int updateUser(int id, String pwd);

    public int deleteUser(String id);

    public List<T_User> showAll();
}
