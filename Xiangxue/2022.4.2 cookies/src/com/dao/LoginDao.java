package com.dao;

import com.pojo.T_User;

public interface LoginDao {
    public T_User login(String uname,String pwd);
}
