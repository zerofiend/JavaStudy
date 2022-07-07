package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.T_User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = null;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public T_User login(String uname, String pwd) {
        return userDao.login(uname, pwd);
    }
}
