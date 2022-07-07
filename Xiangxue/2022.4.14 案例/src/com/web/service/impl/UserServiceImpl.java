package com.web.service.impl;

import com.web.dao.UserDao;
import com.web.dao.impl.UserDaoImpl;
import com.web.pojo.T_User;
import com.web.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = null;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public T_User loginUser(String uname, String pwd) {
        return userDao.loginUser(uname, pwd);
    }

    @Override
    public int addUser(String uname, String pwd) {
        return userDao.addUser(uname, pwd);
    }

    @Override
    public int updateUser(int id, String pwd) {
        return userDao.updateUser(id, pwd);
    }

    @Override
    public int deleteUser(String id) {
        return userDao.deleteUser(id);
    }

    @Override
    public List<T_User> showAll() {
        return userDao.showAll();
    }
}
