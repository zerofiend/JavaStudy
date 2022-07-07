package com.test;

import com.dao.UserDao;
import com.dao.impl.ImplUserDao;
import org.junit.Test;

public class MainTest {
    @Test
    public void testInsert() {
        UserDao userDao = new ImplUserDao();
        userDao.insert(4, "赵六", "123");
    }

    @Test
    public void testDelete() {
        UserDao userDao = new ImplUserDao();
        userDao.delete(4);
    }

    @Test
    public void testUpdate() {
        UserDao userDao = new ImplUserDao();
        userDao.update(4, "六", "123");
    }

    @Test
    public void testSelect() {
        UserDao userDao = new ImplUserDao();
        userDao.select(4);
    }

    @Test
    public void testSelectAll() {
        UserDao userDao = new ImplUserDao();
        userDao.selectAll();
    }
}
