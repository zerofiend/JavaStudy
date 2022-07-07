package com.test;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import org.junit.Test;

public class TestUserDaoImpl {
    @Test
    public void testFindAll() {
        UserDao userDao = new UserDaoImpl();
        userDao.findAll();
    }

    @Test
    public void testLogin() {
        UserDao userDao = new UserDaoImpl();
        userDao.login("王五", "123");
    }

    @Test
    public void testInsert() {
        UserDao userDao = new UserDaoImpl();
        userDao.insert(4, "赵六", "123");
    }

    @Test
    public void testDelete() {
        UserDao userDao = new UserDaoImpl();
        userDao.delete(4);
    }

    @Test
    public void testUpdate() {
        UserDao userDao = new UserDaoImpl();
        userDao.update(4, "六", "123");
    }
}
