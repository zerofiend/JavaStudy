package com.mapper;

import com.pojo.Users;

import java.util.List;

public interface UserMapper {
    public List<Users> selBy(Users users);

    public List<Users> selBy2(Users users);

    public int update(Users users);

    public List<Users> selLike(String uname);

    public List<Users> selLike2(String uname);

    public List<Users> selIn(List<Integer> list);

    public void addBush(List<Users> list);

    public List<Users> selSame(String uname);
}
