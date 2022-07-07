package com.test;

import com.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
    SqlSession sqlSession;

    public Demo() {
        String resource = "mybatis.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = sessionFactory.openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void showAll() {
        List<Users> selAll = sqlSession.selectList("selAll");
        System.out.println(selAll);
        sqlSession.close();
    }
}
