package com.mybatis.test;

import com.mybatis.mapper.ClassMapper;
import com.mybatis.mapper.StuMapper;
import com.mybatis.mapper.TUserMapper;
import com.mybatis.pojo.Stu;
import com.mybatis.pojo.StuExample;
import com.mybatis.pojo.TUser;
import com.mybatis.pojo.TUserExample;
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
    StuMapper stuMapper;
    ClassMapper classMapper;
    TUserMapper userMapper;
    SqlSession sqlSession;

    //  遍历方法
    public <T> void printAll(List<T> demos) {
        for (Object demo : demos) {
            System.out.println(demo.toString());
        }
    }

    //    判断是否操作成功
    public String isSuccess(int judge) {
        return judge > 0 ? "操作成功" : "操作失败";
    }

    public Demo() {
        String resource = "mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = sessionFactory.openSession();
            stuMapper = sqlSession.getMapper(StuMapper.class);
            classMapper = sqlSession.getMapper(ClassMapper.class);
            userMapper = sqlSession.getMapper(TUserMapper.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    TUser user = new TUser();

    /*
        查询所有学生
     */
    @Test
    public void selectAllStu1() {
//        查询所有学生传入数据为null
        List<Stu> stus = stuMapper.selectByExample(null);
        printAll(stus);
    }

    /*
        根据id查（主键）学生
     */
    @Test
    public void selectStuByStuId() {
        Stu stu = stuMapper.selectByPrimaryKey(11);
        System.out.println(stu);
    }

    /*
        根据用户名和密码查用户
     */
    @Test
    public void SelUserByExample() {
        TUserExample example = new TUserExample();
        example.createCriteria().andUnameEqualTo("Alice").andPwdEqualTo("12345");
        List<TUser> tUsers = userMapper.selectByExample(example);
        if (tUsers != null && tUsers.size() == 1) {
            TUser user = tUsers.get(0);
            System.out.println(user);
        }
    }

    /*
        根据用户名删除用户信息
     */
    @Test
    public void deleteUserByName() {
        TUserExample example = new TUserExample();
        example.createCriteria().andUnameEqualTo("张三");
        int n = userMapper.deleteByExample(example);
        System.out.println(n == 1 ? "删除成功" : "删除失败");
        sqlSession.commit();
    }

    /*
        根据id删除用户信息
     */
    @Test
    public void deleteUserById() {
        TUserExample example = new TUserExample();
        example.createCriteria().andIdEqualTo(2);
        int n = userMapper.deleteByExample(example);
        System.out.println(n == 1 ? "删除成功" : "删除失败");
        sqlSession.commit();
    }

    /*
        根据年龄范围查找学生信息
     */
    @Test
    public void selectStuBetweenAge() {
        StuExample example = new StuExample();
        example.createCriteria().andAgeBetween(18, 20);
        List<Stu> stus = stuMapper.selectByExample(example);
        printAll(stus);
        System.out.println("--------------------");
        /*  通过list查找范围内数据    */
        StuExample example1 = new StuExample();
        List<Integer> list = new ArrayList<>();
        list.add(19);
        list.add(21);
        example1.createCriteria().andAgeIn(list);
        List<Stu> stus1 = stuMapper.selectByExample(example1);
        printAll(stus1);
        System.out.println("--------------------");
        /*  通过区间查找  */
        StuExample example2 = new StuExample();
        example2.createCriteria().andAgeGreaterThan(18).andAgeLessThanOrEqualTo(20);
        List<Stu> stus2 = stuMapper.selectByExample(example2);
        printAll(stus2);
    }

    /*
        修改用户信息
     */
    @Test
    public void updateUser1() {
        user.setId(9);
        user.setUname("王五");
        user.setPwd("12345");
        int n = userMapper.updateByPrimaryKey(user);
        System.out.println(isSuccess(n));
        sqlSession.commit();
    }

    @Test
    public void updateUser2() {
        user.setId(9);
        user.setPwd("123");
        int n = userMapper.updateByPrimaryKeySelective(user);
        System.out.println(isSuccess(n));
        sqlSession.commit();
    }

    @Test
    public void updateUser3() {
        user.setPwd("123");
        TUserExample example = new TUserExample();
        example.createCriteria().andUnameEqualTo("Alice");
        int n = userMapper.updateByExampleSelective(user, example);
        System.out.println(isSuccess(n));
        sqlSession.commit();
    }

    /*
        新增学生信息
     */
    @Test
    public void insertStu() {
        Stu stu = new Stu();
        stu.setStuName("admin");
        stu.setAge(88);
        stu.setClassId(3);
        int insert = stuMapper.insert(stu);
        System.out.println(isSuccess(insert));
        sqlSession.commit();
    }

    @Test
    public void insertStu2() {
        Stu stu = new Stu();
        stu.setStuName("admin");
        int insert = stuMapper.insertSelective(stu);
        System.out.println(isSuccess(insert));
        sqlSession.commit();
    }
}
