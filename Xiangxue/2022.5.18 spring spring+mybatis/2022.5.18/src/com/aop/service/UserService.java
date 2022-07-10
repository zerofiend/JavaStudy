package com.aop.service;

import com.aop.pojo.CUser;

public interface UserService {
    public CUser loginUser(String uname, String pwd);
}
