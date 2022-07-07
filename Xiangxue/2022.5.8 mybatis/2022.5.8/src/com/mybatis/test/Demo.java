package com.mybatis.test;


import com.mybatis.mapper.UserMapper;
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

public class Demo {
    SqlSession sqlSession;
    Logger log;
    UserMapper mapper;

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
            /*  通过session对象创建UserMapper对象
            *   等同于匿名对象
            * new UserMapper(){

                @Override
                public List<Users> selAll() {
                    return null;
                }
            }
            */
            mapper = sqlSession.getMapper(UserMapper.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void selAll() {
        List<Users> users = mapper.selAll();
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void selBy() {
        Users user1 = mapper.selBy("李四", "123");
        System.out.println(user1);
        sqlSession.close();
    }

    @Test
    public void selBy2() {
        Users user = new Users();
        user.setId(1);
        Users user2 = mapper.selBy2(user);
        System.out.println(user2);
        sqlSession.close();
    }

    @Test
    public void update() {
        Users user = new Users();
        user.setUname("张三");
        user.setPwd("12345");
        int update = mapper.update(user);
        System.out.println(update == 1 ? "修改成功" : "修改失败");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void add() {
        Users users = new Users();
        users.setUname("王五");
        users.setPwd("123");
        int add = mapper.add(users);
        System.out.println(add);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delete() {
        int delete = mapper.delete(8);
        System.out.println(delete);
        sqlSession.commit();
        sqlSession.close();
    }
}
