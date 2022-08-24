package com.xiangxue.service.impl;

import com.xiangxue.mapper.UserMapper;
import com.xiangxue.pojo.User;
import com.xiangxue.service.UserService;
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
