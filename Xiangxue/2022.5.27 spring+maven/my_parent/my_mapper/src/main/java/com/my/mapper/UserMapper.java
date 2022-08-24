package com.my.mapper;

import com.my.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public User login(String uname, String pwd);
}
