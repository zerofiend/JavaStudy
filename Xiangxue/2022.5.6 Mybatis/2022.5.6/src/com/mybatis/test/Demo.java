package com.mybatis.test;


import com.mybatis.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Demo {
    SqlSession sqlSession;
    Logger log;

    public Demo() {
        log = Logger.getLogger(Demo.class);
        /*  加载配置文件  */
        String resource = "mybatis.xml";    //这个文件放在src目录下
        InputStream in = null;
        try {
            /*创建实例*/
            in = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            /*  创建一个可以发送sql语句的对象*/
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void selBy() {
        Users users = sqlSession.selectOne("selBy");
        System.out.println(users);
        log.debug(users);
        sqlSession.close(); /*把链接对象放回连接池*/
    }

    @Test
    public void selList() {
        List<Users> list = sqlSession.selectList("selAll");
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void selMap() {
        Map<Integer, Users> map = sqlSession.selectMap("selAll", "id");
        System.out.println(map.get(1));
        sqlSession.close();
    }

    @Test
    public void add() {
        int n = sqlSession.insert("addUser");
        System.out.println(n == 1 ? "新增成功" : "新增失败");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update() {
        int n = sqlSession.insert("updateUser");
        System.out.println(n == 1 ? "修改成功" : "修改失败");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delete() {
        int n = sqlSession.insert("deleteUser");
        System.out.println(n == 1 ? "删除成功" : "删除失败");
        sqlSession.commit();
        sqlSession.close();
    }
}
