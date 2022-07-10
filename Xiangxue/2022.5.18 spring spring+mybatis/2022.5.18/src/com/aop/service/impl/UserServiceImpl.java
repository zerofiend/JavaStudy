package com.aop.service.impl;

import com.aop.mapper.CUserMapper;
import com.aop.pojo.CUser;
import com.aop.pojo.CUserExample;
import com.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private CUserMapper userMapper;

    @Override
    public CUser loginUser(String uname, String pwd) {
        CUserExample example = new CUserExample();
        example.createCriteria().andUnameEqualTo(uname).andPwdEqualTo(pwd);
        List<CUser> cUsers = userMapper.selectByExample(example);
        if (cUsers != null && cUsers.size() == 1) {
            return cUsers.get(0);
        }
        return null;
    }
}
