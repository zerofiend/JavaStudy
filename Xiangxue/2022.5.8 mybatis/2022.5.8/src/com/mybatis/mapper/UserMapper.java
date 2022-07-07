package com.mybatis.mapper;

import com.mybatis.pojo.Users;

import java.util.List;

public interface UserMapper {
    public List<Users> selAll();

    public Users selBy(String uname, String pwd);

    public Users selBy2(Users users);

    public int update(Users users);

    public int add(Users users);

    public int delete(int id);
}
