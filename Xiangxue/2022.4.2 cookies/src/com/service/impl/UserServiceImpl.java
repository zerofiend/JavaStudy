package com.service.impl;

import com.dao.LoginDao;
import com.dao.impl.LoginDaoImpl;
import com.pojo.T_User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
    LoginDao loginDao = null;

    public UserServiceImpl() {
        loginDao = new LoginDaoImpl();
    }

    @Override
    public T_User login(String uname, String pwd) {
//        通过dao层访问数据库
        return loginDao.login(uname, pwd);
    }
}
