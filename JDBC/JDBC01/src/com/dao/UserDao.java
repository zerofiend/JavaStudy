package com.dao;

public interface UserDao {
    //  增
    void insert(int id, String userName, String password);

    //  删
    void delete(int id);

    //  改
    void update(int id, String userName, String password);

    //  查
    void select(int id);

    //  查找所有
    void selectAll();
}
