package com.test;

import com.mapper.UserMapper;
import com.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    UserMapper mapper;
    SqlSession sqlSession;

    public Demo() {
        String resource = "mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = sessionFactory.openSession();
            mapper = sqlSession.getMapper(UserMapper.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void selBy1() {
        Users user = new Users();
        user.setPwd("12345");
        List<Users> users = mapper.selBy(user);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void selBy2() {
        Users user = new Users();
        user.setPwd("12345");
        user.setUname("Alice");
        List<Users> users = mapper.selBy2(user);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void update() {
        Users user = new Users();
        user.setId(10);
        user.setPwd("12345");
        user.setUname("Alice");
        int n = mapper.update(user);
        System.out.println(n);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selLike() {
        List<Users> users = mapper.selLike("三");
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void selLike2() {
        List<Users> users = mapper.selLike2("三");
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void selIn() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(9);
        list.add(2);
        List<Users> users = mapper.selIn(list);
        System.out.println(users);
        sqlSession.close();
    }

    /*
     *   默认批量插入的大小为1M
     */
    @Test
    public void addBash() {
        List<Users> list = new ArrayList<>();
        list.add(new Users("ben", "12345"));
        list.add(new Users("catty", "12345"));
        list.add(new Users("dannel", "123"));
        list.add(new Users("eddie", "12345"));
        list.add(new Users("furry", "123"));
        mapper.addBush(list);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selSame() {
        List<Users> users = mapper.selSame("张三");
        System.out.println(users);
        sqlSession.close();
    }
}
