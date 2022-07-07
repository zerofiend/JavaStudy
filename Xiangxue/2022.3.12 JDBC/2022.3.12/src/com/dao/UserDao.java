package com.dao;

public interface UserDao {
    //  查询所有
    void findAll();

    //  登录
    void login(String userName, String password);

    //  增
    void insert(int id, String userName, String password);

    //  删
    void delete(int id);

    //  改
    void update(int id, String userName, String password);
}
