package com.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.ClassMapper;
import com.mapper.StuMapper;
import com.pojo.Class;
import com.pojo.Stu;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
    StuMapper stuMapper;
    ClassMapper classMapper;
    SqlSession sqlSession;

    public Demo() {
        String resource = "mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = sessionFactory.openSession();
            stuMapper = sqlSession.getMapper(StuMapper.class);
            classMapper = sqlSession.getMapper(ClassMapper.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        N+1(手动装配方式)方式实现多表查询
     */
    @Test
    public void findAll1() {
        long time1 = System.currentTimeMillis();
        List<Stu> stus = stuMapper.selAll();
        for (Stu stu : stus) {
            int classId = stu.getClassId();
            /*  根据classId查学生的班级信息   */
            Class aClass = classMapper.selById(classId);
            stu.setaClass(aClass);
        }
        for (Stu stu : stus) {
            System.out.println(stu);
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        sqlSession.close();
    }

    /*
        通过在xml配置文件内配置实现多表查询
    */
    @Test
    public void findAll2() {
        long time1 = System.currentTimeMillis();
        List<Stu> stus = stuMapper.selAll2();
        for (Stu stu : stus) {
            System.out.println(stu);
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        sqlSession.close();
    }

    /*
        方式三 用sql语句和resultMap
    */
    @Test
    public void findAll3() {
        long time1 = System.currentTimeMillis();
        List<Stu> stus = stuMapper.selAll3();
        for (Stu stu : stus) {
            System.out.println(stu);
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        sqlSession.close();
    }

    /*
        一对多
        查询班级信息以及里面所有的学生信息
        手动装配
    */
    @Test
    public void selClassMsg() {
        List<Class> all = classMapper.findAll();
        for (Class aClass : all) {
            int classId = aClass.getClassId();
            /*  通过classId查持有这个外键的Stu    */
            List<Stu> stus = stuMapper.selByClassId(classId);
            aClass.setStus(stus);
        }
        for (Class aClass : all) {
            System.out.println(aClass);
        }
    }

    /*
        在配置文件里装配
    */
    @Test
    public void selClassMsg2() {
        List<Class> all = classMapper.findAll2();
        for (Class aClass : all) {
            System.out.println(aClass);
        }
    }

    /*
        使用多表关联的sql语句
    */
    @Test
    public void selClassMsg3() {
        List<Class> all = classMapper.findAll3();
        for (Class aClass : all) {
            System.out.println(aClass);
        }
    }

    /*
        分页查询
    */
    @Test
    public void selDate() {
        /*  使用pageHelper插件实现分页  */
        int pageStart = 0;
        int pageSize = 3;
        PageHelper.startPage(pageStart, pageSize);
        /*  查数据库操作一定要在startPage之后   */
        List<Stu> stus = stuMapper.selAll2();
        PageInfo<Stu> result = new PageInfo<>(stus);
        System.out.println("分页处理后的数据：" + result.getList());
        System.out.println("当前的页码：" + result.getPageNum());
        System.out.println("数据的总数：" + result.getTotal());
    }
}
