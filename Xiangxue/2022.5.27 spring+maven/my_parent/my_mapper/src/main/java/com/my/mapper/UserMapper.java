package com.xiangxue.mapper;

import com.xiangxue.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public User login(String uname, String pwd);
}
