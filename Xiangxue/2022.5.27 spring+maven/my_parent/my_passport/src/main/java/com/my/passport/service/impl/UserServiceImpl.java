package com.my.passport.service.impl;


import com.my.mapper.UserMapper;
import com.my.passport.service.UserService;
import com.my.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String uname, String pwd) {
        return userMapper.login(uname, pwd);
    }
}
