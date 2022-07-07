package com.test;

import com.mapper.UserMapper;
import com.pojo.Users;
import com.pojo.Users2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
    UserMapper mapper;
    UserMapper mapper2;
    SqlSession sqlSession;
    SqlSession sqlSession2;

    public Demo() {
        String resource = "mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = sessionFactory.openSession();
            sqlSession2 = sessionFactory.openSession();
            mapper = sqlSession.getMapper(UserMapper.class);
            mapper2 = sqlSession2.getMapper(UserMapper.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void find() {
        Users user = new Users();
        user.setPwd("123");
        List<Users> list = mapper.selBy(user);
        System.out.println(list);
        sqlSession.close();
        /*测试二级缓存*/
        List<Users> list1 = mapper2.selBy(user);
        System.out.println(list1);
        sqlSession2.close();
    }

    @Test
    public void delete() {
        int n = mapper.delete(4);
        System.out.println(n);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insert() {
        Users user = new Users();
        user.setUname("google");
        user.setPwd("123");
        int n = mapper.insert(user);
        System.out.println(n);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update() {
        Users user = new Users();
        user.setUname("google");
        user.setPwd("12345");
        int n = mapper.update(user);
        System.out.println(n);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selBy2() {
        List<Users2> users2s = mapper.selBy2(new Users2());
        System.out.println(users2s);
        sqlSession.close();
    }
}
